package com.fpmislata.movies.persistence.dao;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.mapper.ActorMapper;
import com.fpmislata.movies.persistence.model.ActorEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ActorsDAO {

    public List<ActorEntity> getAllActors(Connection connection){
        final String SQL= "select * from actors";
        List<ActorEntity> actorEntities = new ArrayList<>();

        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,null);
            while (resultSet.next()){
                actorEntities.add(ActorMapper.mapper.toActorEnity(resultSet));
            }
            return actorEntities;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Optional<ActorEntity> findActorById(Connection connection ,int id){
        final String SQL="select * from actors where id=?";
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            return Optional.ofNullable(resultSet.next()? ActorMapper.mapper.toActorEnity(resultSet) : null);
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public List<ActorEntity> findActorsByMovieID(Connection connection ,int id){
        final String SQL = """
                    SELECT a.* FROM actors a
                    INNER JOIN actors_movies am ON am.actor_id = a.id
                    INNER JOIN movies m ON m.id = am.movie_id AND m.id = ?
                """;
        List<ActorEntity> actorEntities = new ArrayList<>();
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            while (resultSet.next()){
                actorEntities.add(ActorMapper.mapper.toActorEnity(resultSet));
            }
            return actorEntities;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public int insertActor(Connection connection, ActorEntity actorEntity){
        final String SQL = "insert into actors (name, birthYear, deathYear) values (?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(actorEntity.getName());
        params.add(actorEntity.getBirthYear());
        params.add(actorEntity.getDeathYear());
        int id = DBUtil.insert(connection,SQL,params);
        return id;
    }

    public void upadte(Connection connection, ActorEntity actorEntity){
        final String SQL="UPDATE actors set name=?, birthYear=?, deathYear=? WHERE id=?";
        List<Object> params = new ArrayList<>();

        params.add(actorEntity.getName());
        params.add(actorEntity.getBirthYear());
        params.add(actorEntity.getDeathYear());
        params.add(actorEntity.getId());
        DBUtil.update(connection,SQL,params);
        DBUtil.closeConnection(connection);
    }

    public void delete(Connection connection, int id){
        final String SQL = "DELETE from actors WHERE id=?";
        DBUtil.delete(connection,SQL,List.of(id));
        DBUtil.closeConnection(connection);
    }
}
