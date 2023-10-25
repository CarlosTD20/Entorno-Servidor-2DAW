package com.fpmislata.movies.controller;


import com.fpmislata.movies.controller.model.actor.ActorCreateWEB;
import com.fpmislata.movies.controller.model.actor.ActorDetailWEB;
import com.fpmislata.movies.controller.model.actor.ActorListWEB;
import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.service.ActorService;
import com.fpmislata.movies.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/actors")
@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<ActorListWEB> getAllActors(){
        List<Actor> actors = actorService.getAllActors();
        List<ActorListWEB> actorWEB = actors.stream()
                .map(actor -> ActorMapper.mapper.toActorListWEB(actor))
                .toList();
        return actorWEB;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public ActorDetailWEB getActorByID(@PathVariable int id){
        return ActorMapper.mapper.toActorDetailWEB(actorService.findActorById(id));
    }
/*
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public ActorDetailWEB insertActor(@RequestBody ActorCreateWEB actorCreateWEB){
        int id = actorService.insertActor(ActorMapper.mapper.toActor(actorCreateWEB));
        ActorDetailWEB actorDetailWEB = new ActorDetailWEB(
                id,
                actorCreateWEB.getName(),
                actorCreateWEB.getBirthYear(),
                actorCreateWEB.getDeathYear()
        );
        return actorDetailWEB;
    }
 */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id,@RequestBody Actor actor){
        actor.setId(id);
        this.actorService.update(actor);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.actorService.delete(id);
    }
}
