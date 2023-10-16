package com.fpmislata.movies.controller;

import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

    Actor actor1 = new Actor("Robert Downey Jr", 1968, null);
    Actor actor2 = new Actor("Chris Evans", 1981,null);

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/insert")
    public void insertActor(){
        try {
            this.actorService.insertActor(this.actor1);
            this.actorService.insertActor(this.actor2);
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
