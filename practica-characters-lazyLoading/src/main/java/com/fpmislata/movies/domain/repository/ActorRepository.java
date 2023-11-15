package com.fpmislata.movies.domain.repository;

import com.fpmislata.movies.domain.entity.Actor;


import java.util.List;
import java.util.Optional;


public interface ActorRepository {
    public List<Actor> getAllActors();
    public Optional<Actor> findActorById(int id);
    public List<Actor> findActorsByMovieID(int id);
    public int insertActor(Actor actor);
    public void update(Actor actor);
    public void delete(int id);
}
