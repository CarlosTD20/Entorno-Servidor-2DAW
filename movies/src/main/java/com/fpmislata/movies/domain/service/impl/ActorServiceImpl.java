package com.fpmislata.movies.domain.service.impl;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.service.ActorService;
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
    public void insertActor(Actor actor) {
        this.actorRepository.insertActor(actor);
    }
}
