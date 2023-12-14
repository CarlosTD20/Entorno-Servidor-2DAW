package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.service.ActorService;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.domain.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;
/*
    @Override
    public List<Actor> getAllActors() {
        return this.actorRepository.getAllActors();
    }

    @Override
    public Actor findActorById(int id) {
        return this.actorRepository.findActorById(id).orElseThrow(()-> new ResourceNotFoundException("Director not found with id: " + id));
    }

    @Override
    public int insertActor(Actor actor) {
        return actorRepository.insertActor(actor);
    }

    @Override
    public void update(Actor actor) {
        actorRepository.update(actor);
    }

    @Override
    public void delete(int id) {
        actorRepository.delete(id);
    }
 */
}
