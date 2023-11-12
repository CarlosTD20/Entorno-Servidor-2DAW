package com.fpmislata.movies.domain.repository;

import com.fpmislata.movies.domain.entity.Character;

import java.util.List;

public interface CharacterRepository {
    public List<Character> findByMovieId(int movieId);
}
