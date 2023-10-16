package com.fpmislata.movies.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.service.MovieService;
import com.fpmislata.movies.http_response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Value("${LIMIT}")
    private Integer LIMIT;

    @Autowired
    private MovieService movieService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response getAll(@RequestParam Optional<Integer> page,Optional<Integer> pageSize){

        int totalRecords = movieService.getTotalNumberOfRecords();

        if (pageSize.isEmpty()){
            pageSize = Optional.of(LIMIT);
        }
            //.describeConstable() -> Permite que un opctional este a NULL
        Response response = new Response(movieService.getAllMovies(page, pageSize),totalRecords,page, pageSize);
        return response;
        /*int limit = (pageSize.isPresent()? pageSize.get() : LIMIT);*/
    }

    /*
    public Map<String,Object> getAll(){
        Map<String,Object> response = new HashMap<>();
        response.put("data",movieService.getAllMovies());
        int totalRecords = movieService.getTotalNumberOfRecords();
        response.put("total records",totalRecords);
        return response;
    }
    */

    /*
    public List<Movie> getAllMovie(){
        try {
            System.out.println(this.movieService.getAllMovies());
            return this.movieService.getAllMovies();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw  e;
        }
    }*/

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable ("id") int id){
        try {
            System.out.println(movieService.findById(id));
            return movieService.findById(id);
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }
}
