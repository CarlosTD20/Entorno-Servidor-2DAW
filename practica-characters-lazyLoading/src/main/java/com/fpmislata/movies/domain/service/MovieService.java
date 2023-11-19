package com.fpmislata.movies.domain.service;

import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.domain.entity.Movie;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    public List<Movie> getAllMovies(Optional<Integer> page, Optional<Integer> pageSize);
    public Movie findById(int id);
    int getTotalNumberOfRecords();
    public int insertMovie(Movie movie, int directorId);
    public void insertCharacterIntoMovie(int movieId, List<Character> characters);
    public void deleteMovie(int moviedId);
}
