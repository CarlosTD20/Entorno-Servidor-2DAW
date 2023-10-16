package com.fpmislata.movies.persistence;

import com.fpmislata.movies.domain.entity.Director;

import java.util.List;

public interface DirectorRepository {
    public List<Director> getAllDirector();
    public Director findDirectorById(int id);

    public int insertDirector(Director director);

    public void update(Director director);
}
