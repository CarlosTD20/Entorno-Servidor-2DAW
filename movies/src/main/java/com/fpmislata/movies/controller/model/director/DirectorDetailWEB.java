package com.fpmislata.movies.controller.model.director;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DirectorDetailWEB {
    private int id;
    private String name;
    private int birthYear;
    private Integer deathYear;
}
