package com.fpmislata.movies.domain.service;

import com.fpmislata.movies.domain.entity.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    public List<Movie> getAllMovies(Optional<Integer> page, Optional<Integer> pageSize);
    public Movie findById(int id);
    int getTotalNumberOfRecords();
}
