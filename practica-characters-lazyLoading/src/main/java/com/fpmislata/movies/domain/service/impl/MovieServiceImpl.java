package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.repository.ActorRepository;
import com.fpmislata.movies.domain.service.MovieService;
import com.fpmislata.movies.domain.repository.DirectorRepository;
import com.fpmislata.movies.domain.repository.MovieRepository;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;
    //@Autowired
    //private CharacterRepository characterRepository;
    @Autowired
    private DirectorRepository directorRepository;


    @Override
    public List<Movie> getAll(Integer page, Integer pageSize) {
        return movieRepository.getAll(page,pageSize);
    }

    @Override
    public long getTotalNumberOfRecords() {
        return movieRepository.getTotalOfRecords();
    }

/*
    @Override
    public List<Movie> getAllMovies(Optional<Integer> page, Optional<Integer> pageSize) {
        return this.movieRepository.getAllMovie(page,pageSize);
    }

    @Override
    public Movie findById(int id) {
        Movie movie = movieRepository.getMovieById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        //Director director  = directorRepository.findDirectorByMovieId(id).orElseThrow(()-> new ResourceNotFoundException("Director not found with id: " + id));;
        //List<Actor> actors = actorRepository.findActorsByMovieID(id);
        //List<Character> characters = characterRepository.findByMovieId(id);
        //movie.setDirector(director);
        //movie.setCharacters(characters);
        //movie.setActors(actors);
        return movie;
    }

    @Override
    public int getTotalNumberOfRecords() {
        return this.movieRepository.getTotalNumberOfRecords();
    }

    @Override
    public int insertMovie(Movie movie, int directorId) {
        Director director = directorRepository.findDirectorById(directorId)
                .orElseThrow(()->new ResourceNotFoundException("Director not found with:"+ directorId));
        //List<Actor> actors = actorIds.stream()
          //      .map(actorId-> actorRepository.findActorById(actorId)
            //            .orElseThrow(()->new ResourceNotFoundException("Director not found with:"+ actorIds)))
              //  .toList();
        movie.setDirector(director);
        //movie.setActors(actors);
        return movieRepository.insertMovie(movie);
    }

    @Override
    public void insertCharacterIntoMovie(int movieId, List<Character> characters){
        //DEBERÍAS CREAR ACTORES Y MOVIES
        //for (Character character: characters) {
          //  buscar actor por character.getActor.getId()
        //}
        movieRepository.insertCharacterIntoMovie(movieId,characters);
    }

    @Override
    public void deleteMovie(int moviedId) {
        movieRepository.deleteMovie(moviedId);
    }
 */
}
