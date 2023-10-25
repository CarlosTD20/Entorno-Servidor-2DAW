package com.fpmislata.movies.persistence;

import com.fpmislata.movies.domain.entity.Movie;


import java.util.List;
import java.util.Optional;


public interface MovieRepository {
    public List<Movie> getAllMovie(Optional<Integer> page,Optional<Integer> pageSize);
    public Movie getMovieById(int id);
    int getTotalNumberOfRecords();
}
