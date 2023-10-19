package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.exception.SQLStatmentException;
import com.fpmislata.movies.persistence.DirectorRepository;
import org.springframework.stereotype.Repository;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DirectorRepositoryImpl implements DirectorRepository {

    @Override
    public int insertDirector(Director director) {
        final String SQL="insert into directors (name, birthYear, deathYear) values (?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(director.getName());
        params.add(director.getBirthYear());
        params.add(director.getDeathYear());
        Connection connection = DBUtil.getConnection();
        int id = DBUtil.insert(connection,SQL,params);
        DBUtil.closeConnection(connection);

        return id;
    }

    @Override
    public void update(Director director) {
        final String SQL = "UPDATE directors set name=?, birthYear=?, deathYear=? WHERE id=?";

        List<Object> params = new ArrayList<>();
        params.add(director.getName());
        params.add(director.getBirthYear());
        params.add(director.getDeathYear());
        params.add(director.getId());
        Connection connection =DBUtil.getConnection();
        DBUtil.update(connection,SQL,params);
        DBUtil.closeConnection(connection);
    }

    @Override
    public void delete(int id) {
        final String SQL = "DELETE from directors WHERE id=?";
        Connection connection = DBUtil.getConnection();
        DBUtil.delete(connection,SQL, List.of(id));
        DBUtil.closeConnection(connection);
    }

    @Override
    public List<Director> getAllDirector() {
        List<Director> director= new ArrayList<>();
        final String SQL = "select * from directors";
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet = DBUtil.select(connection,SQL, null);
            while (resultSet.next()){
                director.add(
                        new Director(
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("birthYear"),
                                resultSet.getInt("deathYear")
                        )
                );
            }
            DBUtil.closeConnection(connection);
            return director;
        }  catch (SQLException e){
            throw new SQLStatmentException( "SQL " + SQL);
        }
    }

    @Override
    public Director findDirectorById(int id) {
        final  String SQL = "select * from directors where id=?";
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            DBUtil.closeConnection(connection);
            if (resultSet.next()){
                return new Director(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("birthYear"),
                        resultSet.getInt("deathYear")
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
}
