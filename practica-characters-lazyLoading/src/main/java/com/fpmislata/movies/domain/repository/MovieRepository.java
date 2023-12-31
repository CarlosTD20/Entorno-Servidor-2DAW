package com.fpmislata.movies.domain.repository;

import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.entity.Movie;


import java.util.List;
import java.util.Optional;


public interface MovieRepository {

    public Optional<Movie> findById(int movie_id);
    public List<Movie> getAll(Integer page, Integer pageSize);
    public long getTotalOfRecords();
    /*
    public List<Movie> getAllMovie(Optional<Integer> page,Optional<Integer> pageSize);
    public Optional<Movie> getMovieById(int id);
    int getTotalNumberOfRecords();
    public int insertMovie(Movie movie);
    public void insertCharacterIntoMovie(int moviedId, List<Character> character);
    public void deleteMovie(int movieId);
     */
}
