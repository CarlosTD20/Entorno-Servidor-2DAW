package com.fpmislata.movies.persistence.impl;

import com.fpmislata.movies.db.DBUtil;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.exception.DBConnectionException;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.exception.SQLStatmentException;
import com.fpmislata.movies.persistence.MovieRepository;
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

    @Value("${LIMIT}")
    private int LIMIT;

    @Override
    public List<Movie> getAllMovie(Optional<Integer> page, Optional<Integer> pageSize){
        List<Movie> movie = new ArrayList<>();
        String SQL= "select * from movies";
        if(page.isPresent()) {    //Comprueba si se nos da una pagina y si existe y luego lo agrega al final de la consulta select el limit con la pagina
                int offset = (page.get() - 1) * pageSize.get();
                SQL += String.format(" LIMIT %d, %d", offset, pageSize.get());

        }

        try(Connection connection = DBUtil.getConnection()){
            ResultSet resultSet = DBUtil.select(connection,SQL,null);
            while (resultSet.next()) {
                movie.add(
                        new Movie(
                                resultSet.getInt("id"),
                                resultSet.getString("title"),
                                resultSet.getInt("year"),
                                resultSet.getInt("runtime")
                        )
                );
            }
            DBUtil.closeConnection(connection);
            return movie;
        } catch (DBConnectionException e){
                throw e;
        } catch (SQLException e) {
            throw new SQLStatmentException("SQL: " + SQL);
        }
    }

    @Override
    public Movie getMovieById(int id) {
        final String SQL="select * from movies where id=?";
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet=DBUtil.select(connection,SQL,List.of(id));
            DBUtil.closeConnection(connection);
            if (resultSet.next()){
                return new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("year"),
                        resultSet.getInt("runtime")
                );
            }else {
                throw new ResourceNotFoundException("Id movie:" + id);
            }
        }catch (DBConnectionException e){
            throw e;
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        }
    }

    @Override
    public Movie getMovieByTitle(String title) {
        final String SQL="select * from moviees where title = ?";
        try (Connection connection = DBUtil.getConnection()){
            ResultSet resultSet=DBUtil.select(connection,SQL, List.of(title));
            DBUtil.closeConnection(connection);
            if (resultSet.next()){
                return new Movie(
                        resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getInt("year"),
                        resultSet.getInt("runtime")
                );
            } else {
                throw new ResourceNotFoundException("Title: " + title);
            }
        } catch (DBConnectionException e){
            throw  e;
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        }
    }

    @Override
    public int getTotalNumberOfRecords() {
        final String SQL="select count(*) from movies";
        try (Connection connection =DBUtil.getConnection()) {
            ResultSet resultSet = DBUtil.select(connection,SQL,null);
            DBUtil.closeConnection(connection);
            resultSet.next();
            return (int) resultSet.getInt(1);
        } catch (SQLException e){
            throw new SQLStatmentException("SQL: " + SQL);
        }


    }
}
