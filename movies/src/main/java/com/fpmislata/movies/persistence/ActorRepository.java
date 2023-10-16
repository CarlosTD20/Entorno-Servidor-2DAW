package com.fpmislata.movies.persistence;

import com.fpmislata.movies.domain.entity.Actor;


import java.util.List;


public interface ActorRepository {
    public List<Actor> getAllActors();
    public Actor findActorById(int id);
    public void insertActor(Actor actor);
}
