package com.fpmislata.movies.domain.repository;

import com.fpmislata.movies.domain.entity.Movie;


import java.util.List;
import java.util.Optional;


public interface MovieRepository {
    public List<Movie> getAllMovie(Optional<Integer> page,Optional<Integer> pageSize);
    public Optional<Movie> getMovieById(int id);
    int getTotalNumberOfRecords();
}
