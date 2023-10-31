package com.fpmislata.movies.persistence.dao;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.mapper.MovieMapper;
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
}