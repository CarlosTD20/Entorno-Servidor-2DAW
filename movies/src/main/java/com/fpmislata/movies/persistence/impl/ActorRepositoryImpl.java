package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.exception.SQLStatmentException;
import com.fpmislata.movies.domain.repository.ActorRepository;
import com.fpmislata.movies.mapper.ActorMapper;
import com.fpmislata.movies.persistence.dao.ActorsDAO;
import com.fpmislata.movies.persistence.model.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepositoryImpl implements ActorRepository {

    @Autowired
    ActorsDAO actorsDAO;

    @Override
    public List<Actor> getAllActors() {
        try (Connection connection = DBUtil.getConnection(true)){
            List<ActorEntity> actorEntities = actorsDAO.getAllActors(connection);
            List<Actor> actors = actorEntities.stream()
                    .map(actorEntity -> ActorMapper.mapper.toActor(actorEntity))
                    .toList();
            return actors;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Actor findActorById(int id) {
        try (Connection connection = DBUtil.getConnection(true)){
            Optional<ActorEntity> actorEntity = actorsDAO.findActorById(connection,id);
            return ActorMapper.mapper.toActor(actorEntity.get());
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Actor> findActorsByMovieID(int id){
        try (Connection connection = DBUtil.getConnection(true)){
            List<ActorEntity> actorEntities = actorsDAO.findActorsByMovieID(connection,id);
            List<Actor> actors = actorEntities.stream()
                    .map(actorEntity -> ActorMapper.mapper.toActor(actorEntity))
                    .toList();
            return actors;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public int insertActor(Actor actor) {
        try (Connection connection = DBUtil.getConnection(true)){
            return actorsDAO.insertActor(connection,ActorMapper.mapper.toActorEntity(actor));
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(Actor actor) {
        try (Connection connection = DBUtil.getConnection(true)){
            actorsDAO.upadte(connection,ActorMapper.mapper.toActorEntity(actor));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DBUtil.getConnection(true)){
            actorsDAO.delete(connection,id);
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
