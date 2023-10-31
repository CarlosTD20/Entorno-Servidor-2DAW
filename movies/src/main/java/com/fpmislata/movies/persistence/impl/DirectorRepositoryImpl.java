package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.exception.SQLStatmentException;
import com.fpmislata.movies.domain.repository.DirectorRepository;
import com.fpmislata.movies.mapper.DirectorMapper;
import com.fpmislata.movies.persistence.dao.DirectorsDAO;
import com.fpmislata.movies.persistence.model.DirectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DirectorRepositoryImpl implements DirectorRepository {

    @Autowired
    DirectorsDAO directorsDAO;

    @Override
    public List<Director> getAllDirector() {
        try (Connection connection=DBUtil.getConnection(true)){
            List<DirectorEntity> directorEntities = directorsDAO.getAllDirectors(connection);
            List<Director> directors = directorEntities.stream()
                    .map(directorEntity -> DirectorMapper.mapper.toDirector(directorEntity))
                    .toList();
            return directors;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Director findDirectorById(int id) {
        try (Connection connection = DBUtil.getConnection(true)){
            Optional<DirectorEntity> directorEntity = directorsDAO.findDirectorById(connection,id);
            return DirectorMapper.mapper.toDirector(directorEntity.get());
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Director findDirectorByMovieId(int id){
        try (Connection connection = DBUtil.getConnection(true)){
            Optional<DirectorEntity> directorEntity = directorsDAO.findDirectorByMovieId(connection,id);
            return DirectorMapper.mapper.toDirector(directorEntity.get());
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int insertDirector(Director director) {
        try (Connection connection = DBUtil.getConnection(true)){
            return directorsDAO.insertDirector(connection,DirectorMapper.mapper.toDirectorEntity(director));
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Director director) {
        try (Connection connection = DBUtil.getConnection(true)){
            directorsDAO.update(connection, DirectorMapper.mapper.toDirectorEntity(director));
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBUtil.getConnection(true)){
            directorsDAO.delete(connection,id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
