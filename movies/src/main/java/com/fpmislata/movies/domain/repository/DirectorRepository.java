package com.fpmislata.movies.domain.repository;

import com.fpmislata.movies.domain.entity.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository {
    public List<Director> getAllDirector();
    public Optional<Director> findDirectorById(int id);
    public Optional<Director> findDirectorByMovieId(int id);
    public int insertDirector(Director director);
    public void update(Director director);
    public void delete(int id);
}
