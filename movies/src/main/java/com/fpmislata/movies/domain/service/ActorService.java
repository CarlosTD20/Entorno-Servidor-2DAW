package com.fpmislata.movies.domain.service;

import com.fpmislata.movies.domain.entity.Actor;


import java.util.List;


public interface ActorService {
    public List<Actor> getAllActors();
    public Actor findActorById(int id);
    public int insertActor(Actor actor);
    public void update( Actor actor);
    public void delete(int id);
}
