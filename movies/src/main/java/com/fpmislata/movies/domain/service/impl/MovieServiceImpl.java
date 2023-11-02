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
}
