package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.repository.CharacterRepository;
import com.fpmislata.movies.mapper.CharacterMapper;
import com.fpmislata.movies.persistence.dao.ActorsDAO;
import com.fpmislata.movies.persistence.dao.CharacterDAO;
import com.fpmislata.movies.persistence.model.ActorEntity;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CharacterRepositoryImpl implements CharacterRepository {
    @Autowired
    CharacterDAO characterDAO;

    @Autowired
    ActorsDAO actorsDAO;

    @Override
    public List<Character> findByMovieId(int movieId) {
        try (Connection connection = DBUtil.getConnection(true)){
            List<CharacterEntity> characterEntities = characterDAO.getByMovieId(connection,movieId);
            for (CharacterEntity characterEntity : characterEntities) {
                List<ActorEntity> actorEntity = actorsDAO.findActorsByMovieID(connection, movieId);
                characterEntity.setActorEntity((ActorEntity) actorEntity);
            }
            List<Character> characters = characterEntities.stream()
                    .map(characterEntity -> CharacterMapper.mapper.toCharacter(characterEntity))
                    .toList();

            return characters;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
