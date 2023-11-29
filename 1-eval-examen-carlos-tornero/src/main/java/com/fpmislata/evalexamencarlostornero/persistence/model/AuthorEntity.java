package com.fpmislata.evalexamencarlostornero.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorEntity {
    private int id;
    private String name;
    private String nationality;
    private int birth_year;
    private int death_year;
}
