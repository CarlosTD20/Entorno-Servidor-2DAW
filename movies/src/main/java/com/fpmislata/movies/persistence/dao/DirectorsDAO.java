package com.fpmislata.movies.persistence.dao;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.mapper.DirectorMapper;
import com.fpmislata.movies.persistence.model.DirectorEntity;
import org.springframework.stereotype.Component;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DirectorsDAO {

    public List<DirectorEntity> getAllDirectors(Connection connection){
        String SQL= "select * from directors";
        List<DirectorEntity> directorEntities = new ArrayList<>();
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,null);
            while (resultSet.next()){
                directorEntities.add(DirectorMapper.mapper.toDirectorEntity(resultSet));
            }
            return directorEntities;
        }catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Optional<DirectorEntity> findDirectorById(Connection connection, int id){
        final String SQL="select * from directors where id=?";
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            return Optional.ofNullable(resultSet.next()? DirectorMapper.mapper.toDirectorEntity(resultSet) : null);
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public Optional<DirectorEntity> findDirectorByMovieId(Connection connection, int id){
        final String SQL= """
            SELECT d.* FROM directors d 
            INNER JOIN  movies m ON m.director_id = d.id
            WHERE m.id = ?
            LIMIT 1
                """;
        try {
            ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
            return Optional.ofNullable(resultSet.next()? DirectorMapper.mapper.toDirectorEntity(resultSet) : null);
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }

    public int insertDirector(Connection connection, DirectorEntity directorEntity){
        final String SQL="insert into directors (name, birthYear, deathYear) values (?,?,?)";
        List<Object> params = new ArrayList<>();
        params.add(directorEntity.getName());
        params.add(directorEntity.getBirthYear());
        params.add(directorEntity.getDeathYear());
        int id = DBUtil.insert(connection,SQL,params);
        return id;
    }

    public void update(Connection connection, DirectorEntity directorEntity){
        final String SQL = "UPDATE directors set name=?, birthYear=?, deathYear=? WHERE id=?";

        List<Object> params = new ArrayList<>();
        params.add(directorEntity.getId());
        params.add(directorEntity.getName());
        params.add(directorEntity.getBirthYear());
        params.add(directorEntity.getDeathYear());
        DBUtil.update(connection,SQL,params);
        DBUtil.closeConnection(connection);
    }

    public void delete(Connection connection, int id){
        final String SQL = "DELETE from directors WHERE id=?";
        DBUtil.delete(connection,SQL,List.of(id));
        DBUtil.closeConnection(connection);
    }
}
