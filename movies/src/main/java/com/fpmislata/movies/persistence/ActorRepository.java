package com.fpmislata.movies.persistence;

import com.fpmislata.movies.domain.entity.Actor;


import java.util.List;


public interface ActorRepository {
    public List<Actor> getAllActors();
    public Actor findActorById(int id);
    public List<Actor> findActorsByMovieID(int id);
    public int insertActor(Actor actor);
    public void update(Actor actor);
    public void delete(int id);
}
