package com.fpmislata.movies.controller.model.actor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ActorCreateWEB {
    private String name;
    private int birthYear;
    private Integer deathYear;
}
