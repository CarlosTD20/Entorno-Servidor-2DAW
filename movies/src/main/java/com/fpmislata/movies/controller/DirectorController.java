package com.fpmislata.movies.controller;

import com.fpmislata.movies.controller.model.director.DirectorDetailWEB;
import com.fpmislata.movies.controller.model.director.DirectorListWEB;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.service.DirectorService;
import com.fpmislata.movies.mapper.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/directors")
@RestController
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<DirectorListWEB> getAllDirectos(){
        List<Director> directors = directorService.getAllDirector();
        List<DirectorListWEB> directorWEB = directors.stream()
                .map(director -> DirectorMapper.mapper.toDirectorListWEB(director))
                .toList();
        return directorWEB;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public DirectorDetailWEB getDirectorByID(@PathVariable int id){
       return DirectorMapper.mapper.toDirectorDetailWEB(directorService.findDirectorById(id));
    }

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
        director.setId(id);
        this.directorService.update(director);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.directorService.delete(id);
    }
}
