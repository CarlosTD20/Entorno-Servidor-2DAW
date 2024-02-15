package com.fpmislata.ExamenCTornero.presistence.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "authors")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String nationality;
    @Column(name = "birth_year")
    private Integer birthYear;
    @Column(name = "death_year", nullable = true)
    private Integer deathYear;
}
