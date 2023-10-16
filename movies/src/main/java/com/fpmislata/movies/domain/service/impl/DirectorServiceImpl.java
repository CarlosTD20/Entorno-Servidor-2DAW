package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.service.DirectorService;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.persistence.DirectorRepository;
import com.fpmislata.movies.persistence.impl.DirectorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return this.directorRepository.findDirectorById(id);
    }

    @Override
    public int insertDirector(Director director) {
       return this.directorRepository.insertDirector(director);
    }

    @Override
    public void update(int id, Director director) {
        Director existingDirector = directorRepository.findDirectorById(id);
        if (existingDirector == null){
            throw  new ResourceNotFoundException("Director not found with id: " + id);
        }
        director.setId(id);
        directorRepository.update(director);
    }
}
