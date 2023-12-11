package com.fpmislata.movies.persistence.model;

import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "actors")
public class ActorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //@Column(name = "birth_year")
    private int birthYear;
    //@Column(name = "death_year", nullable = true)
    private Integer deathYear;
}
