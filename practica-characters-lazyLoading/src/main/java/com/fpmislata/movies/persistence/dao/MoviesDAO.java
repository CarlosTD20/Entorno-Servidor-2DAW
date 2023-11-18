package com.fpmislata.movies.persistence.dao;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.mapper.MovieMapper;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import com.fpmislata.movies.persistence.model.MovieEntity;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MoviesDAO {
 public List<MovieEntity> getAllMovies(Connection connection, Optional<Integer> page, Optional<Integer> pageSize){
     String SQL= "select * from movies";
     if(page.isPresent()) {    //Comprueba si se nos da una pagina y si existe y luego lo agrega al final de la consulta select el limit con la pagina
         int offset = (page.get() - 1) * pageSize.get();
         SQL += String.format(" LIMIT %d, %d", offset, pageSize.get());

     }

     List<MovieEntity> movieEntity = new ArrayList<>();
     try {
         ResultSet resultSet = DBUtil.select(connection,SQL,null);
         while (resultSet.next()){
             movieEntity.add(MovieMapper.mapper.toMovieEntity(resultSet));
         }
         return movieEntity;
     } catch (SQLException e){
         throw new RuntimeException();
     }
 }

 public Optional<MovieEntity> getMovieById(Connection connection,int id){
     final String SQL="select * from movies where id=?";
     try {
         ResultSet resultSet = DBUtil.select(connection,SQL,List.of(id));
         return Optional.ofNullable(resultSet.next()? MovieMapper.mapper.toMovieEntity(resultSet):null);
     } catch (SQLException e){
         throw new RuntimeException();
     }
 }

 public int getTotalNumberOfRecords(Connection connection){
     final String SQl="SELECT COUNT(*) FROM MOVIES";
     try {
         ResultSet resultSet = DBUtil.select(connection,SQl, null);
         resultSet.next();
         return resultSet.getInt(1);
     } catch (SQLException e){
         throw new RuntimeException("SQL: " + SQl);
     }
 }

    public void AddCharacterIntoMovie(Connection connection, int movieId, CharacterEntity characterEntity){
     try {
         final String SQL="INSERT INTO actors_movies (movie_id, actor_id ,characters) values (?,?,?)";

         DBUtil.insert(connection,SQL,List.of(movieId,characterEntity.getActorEntity().getId(),characterEntity.getName()));
     }catch (Exception e){
         throw new RuntimeException(e);
     }
    }

    public int insertMovie(Connection connection, MovieEntity movieEntity) throws SQLException{
        try {
            final String SQL="INSERT INTO movies (title, year, runtime, director_id) values (?, ?, ?, ?)";
            List<Object> params = new ArrayList<>();
            params.add(movieEntity.getTitle());
            params.add(movieEntity.getYear());
            params.add(movieEntity.getRuntime());
            params.add(movieEntity.getDirectorEntity().getId());
            int id = DBUtil.insert(connection,SQL,params);
            return id;
        } catch (Exception e){
            connection.rollback();
            throw new RuntimeException(e);
        }
    }

    public void upadteMovies (Connection connection, MovieEntity movieEntity){
        final String SQL="";
    }

    public void updateActorsFromTheMovie(){}

    public void delteActorsFromTheMovie(){}
}