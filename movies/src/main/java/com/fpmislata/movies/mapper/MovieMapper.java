package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.movie.MovieDetailWEB;
import com.fpmislata.movies.controller.model.movie.MovieListWEB;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.persistence.model.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")  //Permite que Spring sea capaz de administrar esta clase
public interface MovieMapper {

    MovieMapper mapper = Mappers.getMapper(MovieMapper.class);


    Movie toMovie(MovieEntity movieEntity);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "title", expression = "java(resultSet.getString(\"title\"))")
    @Mapping(target = "year", expression = "java(resultSet.getInt(\"year\"))")
    @Mapping(target = "runtime", expression = "java(resultSet.getInt(\"runtime\"))")
    MovieEntity toMovieEntity(ResultSet resultSet) throws SQLException;

    MovieListWEB toMovieListWEB(Movie movie); //Lista de Películas
    MovieDetailWEB toMovieDetailWEB(Movie movie);//Detalle de Películas
}
