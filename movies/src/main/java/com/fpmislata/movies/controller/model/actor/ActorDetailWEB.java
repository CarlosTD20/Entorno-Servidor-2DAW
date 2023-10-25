package com.fpmislata.movies.controller.model.actor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class ActorDetailWEB {
    private int id;
    private String name;
    private int birthYear;
    private Integer deathYear;
}
