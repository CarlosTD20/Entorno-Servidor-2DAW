package com.fpmislata.movies.controller;

import com.fpmislata.movies.controller.model.movie.MovieCreateWEB;
import com.fpmislata.movies.controller.model.movie.MovieDetailWEB;
import com.fpmislata.movies.controller.model.movie.MovieListWEB;
import com.fpmislata.movies.controller.model.movie.MovieUpdateWEB;
import com.fpmislata.movies.domain.entity.Movie;
import com.fpmislata.movies.domain.service.MovieService;
import com.fpmislata.movies.http_response.Response;
import com.fpmislata.movies.mapper.MovieMapper;
import jakarta.servlet.annotation.HttpConstraint;
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
        List<MovieListWEB> movieWEB = movies.stream()//stream() separa en onjestos, creando un flujo de elementos de tipo movies.
                .map(movie -> MovieMapper.mapper.toMovieListWEB(movie))
                .toList();

        Response response = new Response(movieWEB,totalRecords,page,pageSize);

        return response;
        /*int limit = (pageSize.isPresent()? pageSize.get() : LIMIT);*/
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response getMovieById(@PathVariable ("id") int id){
        return new Response( MovieMapper.mapper.toMovieDetailWEB(movieService.findById(id)));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
     public Response insertMovie(@RequestBody MovieCreateWEB movieCreateWEB){
        int id = movieService.insertMovie(
                MovieMapper.mapper.toMovie(movieCreateWEB),
                movieCreateWEB.getDirectorId(),
                movieCreateWEB.getActorsId()
        );
        MovieListWEB movieListWEB = new MovieListWEB();
        movieListWEB.setTitle(movieCreateWEB.getTitle());
        movieListWEB.setId(id);
        return new Response(movieListWEB);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateMovie(@PathVariable("id") int movieID, @RequestBody MovieUpdateWEB movieUpdateWEB){

    }
}
