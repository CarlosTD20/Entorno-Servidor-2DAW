package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.controller.model.movie.MovieCreateWEB;
import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.exception.SQLStatmentException;
import com.fpmislata.movies.domain.repository.MovieRepository;
import com.fpmislata.movies.mapper.CharacterMapper;
import com.fpmislata.movies.mapper.MovieMapper;
import com.fpmislata.movies.persistence.dao.ActorsDAO;
import com.fpmislata.movies.persistence.dao.CharacterDAO;
import com.fpmislata.movies.persistence.dao.DirectorsDAO;
import com.fpmislata.movies.persistence.dao.MoviesDAO;
import com.fpmislata.movies.persistence.model.ActorEntity;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import com.fpmislata.movies.persistence.model.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    MoviesDAO moviesDAO;

    @Autowired
    DirectorsDAO directorsDAO;

    @Autowired
    CharacterDAO characterDAO;

    @Autowired
    ActorsDAO actorsDAO;


    @Override
    public List<Movie> getAllMovie(Optional<Integer> page, Optional<Integer> pageSize){
      try (Connection connection = DBUtil.getConnection(true)){
          List<MovieEntity> movieEntities= moviesDAO.getAllMovies(connection,page,pageSize);
          List<Movie> movies = movieEntities.stream()
                  .map(movieEntity -> MovieMapper.mapper.toMovie(movieEntity) )
                  .toList();
          return movies;
      } catch (SQLException e){
          throw new RuntimeException(e);
      }
    }

    @Override
    public Optional<Movie> getMovieById(int id) {
        try (Connection connection = DBUtil.getConnection(true)){
            MovieEntity movieEntity = moviesDAO.getMovieById(connection, id).get();
            if (movieEntity != null){
                movieEntity.getDirectorEntity(connection,directorsDAO);
                movieEntity.getCharacterEntities(connection,characterDAO).forEach(CharacterEntity -> CharacterEntity.getActorEntityByMovieId(connection,actorsDAO));
            }
            return Optional.ofNullable(MovieMapper.mapper.toMovie(movieEntity));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public int getTotalNumberOfRecords() {
        try (Connection connection =DBUtil.getConnection(true)) {
            return moviesDAO.getTotalNumberOfRecords(connection);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int insertMovie(Movie movie){
        try (Connection connection = DBUtil.getConnection(true)){
            MovieEntity movieEntity = MovieMapper.mapper.toMovieEntity(movie);
            int id = moviesDAO.insertMovie(connection,movieEntity);
            return id;
        } catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void insertCharacterIntoMovie(int moviedId, List<Character> character){
        try (Connection connection = DBUtil.getConnection(true)){
            List<CharacterEntity> characterEntities = character.stream()
                    .map(CharacterMapper.mapper::toCharacterEntity)
                    .toList();
             characterEntities.forEach(characterEntity -> moviesDAO.AddCharacterIntoMovie(connection, moviedId, characterEntity));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
