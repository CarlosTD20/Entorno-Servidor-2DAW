package com.fpmislata.movies.controller.model.actor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActorUpdateWEB {
    private int id;
    private String name;
    private int birthYear;
    private Integer deathYear;
}
