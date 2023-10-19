package com.fpmislata.movies.domain.service;

import com.fpmislata.movies.domain.entity.Director;


import java.util.List;


public interface DirectorService {
    public List<Director> getAllDirector();
    public  Director findDirectorById(int id);
    public int insertDirector(Director director);
    public void update( Director director);
    public void delete(int id);
}
