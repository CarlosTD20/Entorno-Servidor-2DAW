package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.service.MovieService;
import com.fpmislata.movies.domain.repository.ActorRepository;
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
    private MovieRepository movieRepository;
    @Autowired
    private ActorRepository actorRepository;
    @Autowired
    private DirectorRepository directorRepository;


    @Override
    public List<Movie> getAllMovies(Optional<Integer> page, Optional<Integer> pageSize) {
        return this.movieRepository.getAllMovie(page,pageSize);
    }

    @Override
    public Movie findById(int id) {
        Movie movie = movieRepository.getMovieById(id).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        Director director  = directorRepository.findDirectorByMovieId(id).orElseThrow(()-> new ResourceNotFoundException("Director not found with id: " + id));;
        List<Actor> actors = actorRepository.findActorsByMovieID(id);
        movie.setDirector(director);
        movie.setActors(actors);

        return movie;
    }

    @Override
    public int getTotalNumberOfRecords() {
        return this.movieRepository.getTotalNumberOfRecords();
    }

    @Override
    public int insertMovie(Movie movie, int directorId, List<Integer> actorIds) {
        Director director = directorRepository.findDirectorById(directorId)
                .orElseThrow(()->new ResourceNotFoundException("Director not found with:"+ directorId));
        List<Actor> actors = actorIds.stream()
                .map(actorId-> actorRepository.findActorById(actorId)
                        .orElseThrow(()->new ResourceNotFoundException("Director not found with:"+ actorIds)))
                .toList();

        movie.setDirector(director);
        movie.setActors(actors);
        return movieRepository.insertMovie(movie);
    }

    @Override
    public void upadteMovies(Movie movie, int directorId) {
        Director director = directorRepository.findDirectorById(directorId).orElseThrow(()-> new RuntimeException("Director not found with id:" +directorId));
        movieRepository.getMovieById(movie.getId()).orElseThrow(()-> new RuntimeException("Movie not found with id:" + movie.getId()));
        movie.setDirector(director);
        movieRepository.upadteMovies(movie);
        //need to add list of actorsID
    }


}
