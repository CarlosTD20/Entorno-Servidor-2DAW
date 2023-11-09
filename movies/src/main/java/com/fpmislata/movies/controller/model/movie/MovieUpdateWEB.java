package com.fpmislata.movies.controller.model.movie;

import com.fpmislata.movies.domain.entity.Director;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieUpdateWEB {
    private int id;
    private String title;
    private int year;
    private int runtime;
    private Integer directorId;
    private List<Integer> actorsId;
}
