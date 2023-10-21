package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.service.ActorService;
import com.fpmislata.movies.exception.ResourceNotFoundException;
import com.fpmislata.movies.persistence.ActorRepository;
import com.fpmislata.movies.persistence.impl.ActorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> getAllActors() {
        return this.actorRepository.getAllActors();
    }

    @Override
    public Actor findActorById(int id) {
        return this.actorRepository.findActorById(id);
    }

    @Override
    public int insertActor(Actor actor) {
        return actorRepository.insertActor(actor);
    }

    @Override
    public void update(Actor actor) {
        Actor existingActor = actorRepository.findActorById(actor.getId());
        if (existingActor == null){
            throw  new ResourceNotFoundException("Actor not found with id: " + actor.getId());
        }
        actorRepository.update(actor);
    }

    @Override
    public void delete(int id) {
        Actor existingActor = actorRepository.findActorById(id);
        if (existingActor == null){
            throw  new ResourceNotFoundException("Actor not found with id: " + id);
        }
        actorRepository.delete(id);
    }
}
