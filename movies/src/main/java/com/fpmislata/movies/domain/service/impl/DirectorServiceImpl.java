package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.service.DirectorService;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.domain.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public List<Director> getAllDirector() {
        return this.directorRepository.getAllDirector();
    }

    @Override
    public Director findDirectorById(int id) {
        Director director = directorRepository.findDirectorById(id).orElseThrow(()-> new ResourceNotFoundException("Director not found with id: " + id));
        return director;
    }

    @Override
    public int insertDirector(Director director) {
       return this.directorRepository.insertDirector(director);
    }

    @Override
    public void update(Director director) {
        directorRepository.findDirectorById(director.getId()).orElseThrow(()-> new ResourceNotFoundException("Director not found with id: " + director.getId()));
        directorRepository.update(director);
    }

    @Override
    public void delete(int id) {
        directorRepository.findDirectorById(id).orElseThrow(()-> new ResourceNotFoundException("Director not found with id: " + id));
        directorRepository.delete(id);
    }
}
