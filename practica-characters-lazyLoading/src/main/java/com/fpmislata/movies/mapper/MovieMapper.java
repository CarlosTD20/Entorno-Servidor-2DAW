package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.character.CharacterListWEB;
import com.fpmislata.movies.controller.model.movie.MovieCreateWEB;
import com.fpmislata.movies.controller.model.movie.MovieDetailWEB;
import com.fpmislata.movies.controller.model.movie.MovieListWEB;
import com.fpmislata.movies.controller.model.movie.MovieUpdateWEB;
import com.fpmislata.movies.domain.entity.Actor;

import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import com.fpmislata.movies.persistence.model.MovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper(componentModel = "spring")  //Permite que Spring sea capaz de administrar esta clase
public interface MovieMapper {

    MovieMapper mapper = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "director",ignore = true)
    @Mapping(target = "characters", ignore = true)
    Movie toMovie(MovieEntity movieEntity);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characters", ignore = true)
    List<Movie> toMovieList(List<MovieEntity> movieEntities);

    MovieListWEB toMovieListWEB(Movie movie);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characters", ignore = true)
    MovieDetailWEB toMovieDetailWEB(Movie movie);

/*
    Movie toMovie(MovieUpdateWEB movieUpdateWEB);

    //@Mapping(target = "directorId", expression = "java(movie.getDirector().getId())")
    @Mapping(target = "directorEntity",expression = "java(DirectorMapper.mapper.toDirectorEntity(movie.getDirector()))")
    @Mapping(target = "characterEntities",expression = "java(mapCharactersToCharactersEntities(movie.getCharacters()))")
    MovieEntity toMovieEntity(Movie movie);

    @Named("mapCharactersToCharactersEntities")
    default List<CharacterEntity> mapCharactersToCharactersEntities(List<Character> character){
        if (character == null){
            return null;
        }
        return character.stream()
                .map(CharacterMapper.mapper::toCharacterEntity)
                .toList();
    }

    @Mapping(target = "characters", expression = "java(mapCharactersToCharactersListWEB(movie.getCharacters()))")
    MovieDetailWEB toMovieDetailWEB(Movie movie);//Detalle de Películas
    @Named("mapCharactersToCharactersListWEB")
    default List<CharacterListWEB> mapCharactersToCharactersListWEB(List<Character> character){
        if (character == null){
            return null;
        }
        return character.stream()
                .map(CharacterMapper.mapper::toCharacterListWEB)
                .toList();
    }


    @Mapping(target = "director", expression = "java(DirectorMapper.mapper.toDirector(movieEntity.getDirectorEntity()))")
    @Mapping(target = "characters", expression = "java(mapCharactersEntitiesToCharacters(movieEntity.getCharacterEntities()))")
    Movie toMovie(MovieEntity movieEntity);

    @Named("characterEntitiesToCharacters")
    default List<Character> mapCharactersEntitiesToCharacters(List<CharacterEntity> characterEntities){
        if (characterEntities == null){
            return null;
        }
        return characterEntities.stream()
                .map(CharacterMapper.mapper::toCharacter)
                .toList();
    }

    @Named("actorsToActorsId")
    default List<Integer> mapActorsToActorIds(List<Actor> actors){
        return actors.stream()
                .map(actor -> actor.getId())
                .toList();
    }

    @Mapping(target = "director", ignore = true)
    //@Mapping(target = "characters", ignore = true)
    Movie toMovie(MovieCreateWEB movieCreateWEB);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "title", expression = "java(resultSet.getString(\"title\"))")
    @Mapping(target = "year", expression = "java(resultSet.getInt(\"year\"))")
    @Mapping(target = "runtime", expression = "java(resultSet.getInt(\"runtime\"))")
    MovieEntity toMovieEntity(ResultSet resultSet) throws SQLException;

    MovieListWEB toMovieListWEB(Movie movie); //Lista de Películas

 */
}
