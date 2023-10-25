package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.movie.MovieDetailWEB;
import com.fpmislata.movies.controller.model.movie.MovieListWEB;
import com.fpmislata.movies.domain.entity.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javax.swing.*;

@Mapper(componentModel = "spring")  //Permite que Spring sea capaz de administrar esta clase
public interface MovieMapper {
    MovieMapper mapper = Mappers.getMapper(MovieMapper.class);

    MovieListWEB toMovieListWEB(Movie movie); //Lista de Películas
    MovieDetailWEB toMovieDetailWEB(Movie movie);//Detalle de Películas
}
