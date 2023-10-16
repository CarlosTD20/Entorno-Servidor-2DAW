package com.fpmislata.movies.domain.service;

import com.fpmislata.movies.domain.entity.Actor;


import java.util.List;


public interface ActorService {
    public List<Actor> getAllActors();
    public Actor findActorById(int id);
    public void insertActor(Actor actor);
}
