package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.service.MovieService;
import com.fpmislata.movies.persistence.ActorRepository;
import com.fpmislata.movies.persistence.DirectorRepository;
import com.fpmislata.movies.persistence.MovieRepository;
import com.fpmislata.movies.persistence.impl.MovieRepositoryImpl;
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

    /*Preguntar porque lo almacena en una variable*/
    @Override
    public Movie findById(int id) {
        Movie movie = movieRepository.getMovieById(id);
        Director director  = directorRepository.findDirectorByMovieId(id);
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
