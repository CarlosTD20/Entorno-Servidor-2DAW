package com.fpmislata.movies.controller.model.movie;

import com.fpmislata.movies.controller.model.actor.ActorListWEB;
import com.fpmislata.movies.controller.model.director.DirectorDetailWEB;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MovieDetailWEB {
    private int id;
    private String title;
    private int year;
    private int runtime;

    private DirectorDetailWEB director;
    private List<ActorListWEB> actors;
}
