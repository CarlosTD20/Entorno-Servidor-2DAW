package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.movie.MovieCreateWEB;
import com.fpmislata.movies.controller.model.movie.MovieDetailWEB;
import com.fpmislata.movies.controller.model.movie.MovieListWEB;
import com.fpmislata.movies.controller.model.movie.MovieUpdateWEB;
import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.persistence.model.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper(componentModel = "spring")  //Permite que Spring sea capaz de administrar esta clase
public interface MovieMapper {

    MovieMapper mapper = Mappers.getMapper(MovieMapper.class);


    Movie toMovie(MovieUpdateWEB movieUpdateWEB);

    @Mapping(target = "directorId", expression = "java(movie.getDirector().getId())")
    @Mapping(target = "actorIds", expression = "java(mapActorsToActorIds(movie.getActors()))")
    MovieEntity toMovieEntity(Movie movie);

    @Named("actorsToActorsId")
    default List<Integer> mapActorsToActorIds(List<Actor> actors){
        return actors.stream()
                .map(actor -> actor.getId())
                .toList();
    }

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "actors", ignore = true)
    Movie toMovie(MovieCreateWEB movieCreateWEB);

    Movie toMovie(MovieEntity movieEntity);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "title", expression = "java(resultSet.getString(\"title\"))")
    @Mapping(target = "year", expression = "java(resultSet.getInt(\"year\"))")
    @Mapping(target = "runtime", expression = "java(resultSet.getInt(\"runtime\"))")
    MovieEntity toMovieEntity(ResultSet resultSet) throws SQLException;

    MovieListWEB toMovieListWEB(Movie movie); //Lista de Películas
    MovieDetailWEB toMovieDetailWEB(Movie movie);//Detalle de Películas
}
