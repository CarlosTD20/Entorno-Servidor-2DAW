package com.fpmislata.movies.controller;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.service.ActorService;
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
    public List<Actor> getAllActors(){
        try {
            System.out.println(this.actorService.getAllActors());
            return this.actorService.getAllActors();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Actor insertActor(@RequestBody Actor actor){
        int id = actorService.insertActor(actor);
        actor.setId(id);
        return actor;
    }

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
