package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.service.MovieService;
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

    @Override
    public List<Movie> getAllMovies(Optional<Integer> page, Optional<Integer> pageSize) {
        return this.movieRepository.getAllMovie(page,pageSize);
    }

    /*Preguntar porque lo almacena en una variable*/
    @Override
    public Movie findById(int id) {
        return this.movieRepository.getMovieById(id);
        /*
        Movie movie = movieRepository.getMovieById(id);
        return movie;
        */
    }

    @Override
    public Movie findByTitle(String title) {
        return this.movieRepository.getMovieByTitle(title);
    }

    @Override
    public int getTotalNumberOfRecords() {
        return this.movieRepository.getTotalNumberOfRecords();
    }
}
