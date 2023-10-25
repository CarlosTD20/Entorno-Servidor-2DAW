package com.fpmislata.movies.controller;

import com.fpmislata.movies.controller.model.movie.MovieDetailWEB;
import com.fpmislata.movies.controller.model.movie.MovieListWEB;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.service.MovieService;
import com.fpmislata.movies.http_response.Response;
import com.fpmislata.movies.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

        if (pageSize.isEmpty()){
            pageSize = Optional.of(LIMIT);
        }
        int totalRecords = movieService.getTotalNumberOfRecords();

        List<Movie> movies =movieService.getAllMovies(page,pageSize);
        List<MovieListWEB> movieWEB = movies.stream()
                .map(movie -> MovieMapper.mapper.toMovieListWEB(movie))
                .toList();

        Response response = new Response(movieWEB,totalRecords,page,pageSize);

        return response;
        /*int limit = (pageSize.isPresent()? pageSize.get() : LIMIT);*/
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MovieDetailWEB getMovieById(@PathVariable ("id") int id){
        return  MovieMapper.mapper.toMovieDetailWEB(movieService.findById(id));
    }
}
