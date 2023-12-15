package com.fpmislata.movies.domain.service;

import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.entity.Movie;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    public Movie findById(int movie_id);
    public List<Movie> getAll(Integer page, Integer pageSize);
    public long getTotalNumberOfRecords();

    /*
    public List<Movie> getAllMovies(Optional<Integer> page, Optional<Integer> pageSize);
    public Movie findById(int id);
    int getTotalNumberOfRecords();
    public int insertMovie(Movie movie, int directorId);
    public void insertCharacterIntoMovie(int movieId, List<Character> characters);
    public void deleteMovie(int moviedId);
     */
}
