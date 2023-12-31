package com.fpmislata.movies.controller;

import com.fpmislata.movies.controller.model.director.DirectorCreateWEB;
import com.fpmislata.movies.controller.model.director.DirectorDetailWEB;
import com.fpmislata.movies.controller.model.director.DirectorListWEB;
import com.fpmislata.movies.controller.model.director.DirectorUpdateWEB;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.domain.service.DirectorService;
import com.fpmislata.movies.http_response.Response;
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
/*
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAllDirectos(){
        List<Director> directors = directorService.getAllDirector();
        List<DirectorListWEB> directorWEB = directors.stream()
                .map(director -> DirectorMapper.mapper.toDirectorListWEB(director))
                .toList();
        return new Response(directorWEB);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response getDirectorByID(@PathVariable int id){
       return new Response(DirectorMapper.mapper.toDirectorDetailWEB(directorService.findDirectorById(id)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response insertDirector(@RequestBody DirectorCreateWEB directorCreateWEB){
        int id =directorService.insertDirector(DirectorMapper.mapper.toDirector(directorCreateWEB));
        DirectorDetailWEB directorDetailWEB = new DirectorDetailWEB(
                id,
                directorCreateWEB.getName(),
                directorCreateWEB.getBirthYear(),
                directorCreateWEB.getDeathYear()
        );
        return new Response(directorDetailWEB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody DirectorUpdateWEB directorUpdateWEB){
        directorUpdateWEB.setId(id);
        this.directorService.update(DirectorMapper.mapper.toDirector(directorUpdateWEB));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        this.directorService.delete(id);
    }
 */
}
