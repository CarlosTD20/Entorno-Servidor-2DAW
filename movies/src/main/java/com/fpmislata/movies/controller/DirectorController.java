package com.fpmislata.movies.controller;

import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/directors")
@RestController
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    /*@ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<Director> getAllDirectos(){
        try {
            System.out.println(this.directorService.getAllDirector());
            return this.directorService.getAllDirector();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }*/

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Director insertDirector(@RequestBody Director director){
        int id =directorService.insertDirector(director);
        director.setId(id);
        return director;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Director director){
        this.directorService.update(id, director);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void delete(@PathVariable("id") int id){
        this.directorService.delete(id);
    }
}
