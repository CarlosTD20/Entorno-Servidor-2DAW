package com.fpmislata.movies.persistence.dao;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.mapper.CharacterMapper;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterDAO {

    public List<CharacterEntity> getByMovieId(Connection connection, int movieId){
        final String SQL="select am.* from actors_movies am, movies m where am.movie_id=m.id and m.id=?";
        List<CharacterEntity> characterEntities = new ArrayList<>();
        try {
            ResultSet resultSet = DBUtil.select(connection, SQL, List.of(movieId));
            while (resultSet.next()){
                characterEntities.add(CharacterMapper.mapper.toCharacterEntity(resultSet));
            }
            return characterEntities;
        } catch (SQLException e){
            throw new RuntimeException();
        }
    }
}
