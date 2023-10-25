package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.exception.SQLStatmentException;
import com.fpmislata.movies.persistence.ActorRepository;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class ActorRepositoryImpl implements ActorRepository {

    @Override
    public List<Actor> getAllActors() {
        List<Actor> actor = new ArrayList<>();
        final String SQL = "select * from actors";
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet = DBUtil.select(connection,SQL,null);
            while (resultSet.next()){
                actor.add(
                        new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("birthYear"),
                                resultSet.getInt("deathYear")
                        )
                );
            }
            DBUtil.closeConnection(connection);
            return actor;
        } catch (DBConnectionException e){
            throw e;
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        }
    }

    @Override
    public Actor findActorById(int id) {
        final String SQL = "select * from actors where id=?";
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet=DBUtil.select(connection,SQL,List.of(id));
            DBUtil.closeConnection(connection);
            if (resultSet.next()){
                return new Actor(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("birthYear"),
                        (resultSet.getObject("deathYear") != null)? resultSet.getInt("deathYear") : null
                );
            } else {
                throw new ResourceNotFoundException("ID: " + id);
            }
        } catch (DBConnectionException e){
            throw e;
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        }
    }

    public List<Actor> findActorsByMovieID(int id){
        List<Actor> actor = new ArrayList<>();
        final String SQL ="""
                    SELECT a.* FROM actors a
                    INNER JOIN actors_movies am ON am.actor_id = a.id
                    INNER JOIN movies m ON m.id = am.movie_id AND m.id = ?
                """;
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            while (resultSet.next()){
                actor.add(
                        new Actor(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("birthYear"),
                                (resultSet.getObject("deathYear") != null)? resultSet.getInt("deathYear") : null
                        )
                );
            }
            DBUtil.closeConnection(connection);
            return actor;
        } catch (DBConnectionException e){
            throw e;
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        }
    }

    @Override
    public int insertActor(Actor actor) {
        final String SQL = "insert into actors (name, birthYear, deathYear) values (?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(actor.getName());
        params.add(actor.getBirthYear());
        params.add(actor.getDeathYear());
        try (Connection connection = DBUtil.getConnection()){
            int id =DBUtil.insert(connection,SQL,params);
            DBUtil.closeConnection(connection);
            return  id;
        } catch (DBConnectionException e){
            throw e;
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void update(Actor actor) {
        final String SQL="UPDATE actors set name=?, birthYear=?, deathYear=? WHERE id=?";
        List<Object> params = new ArrayList<>();
        params.add(actor.getName());
        params.add(actor.getBirthYear());
        params.add(actor.getDeathYear());
        params.add(actor.getId());
        Connection connection= DBUtil.getConnection();
        DBUtil.update(connection,SQL,params);
        DBUtil.closeConnection(connection);
    }

    @Override
    public void delete(int id) {
        final String SQL="DELETE from actors where id=?";
        Connection connection = DBUtil.getConnection();
        DBUtil.delete(connection,SQL,List.of(id));
        DBUtil.closeConnection(connection);
    }
}
