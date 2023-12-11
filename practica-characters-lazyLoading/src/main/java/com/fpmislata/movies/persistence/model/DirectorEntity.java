package com.fpmislata.movies.persistence.model;

import jakarta.persistence.*;
import lombok.*;

//@Getter
//@Setter
@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "directors")
public class DirectorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    //@Column(name = "birth_year")
    private int birthYear;
    //@Column(name = "death_year", nullable = true)
    private Integer deathYear;
}
//@Column(name = "death_year", nullable = true)
//Se utliza para espicificar el nombre que tiene en la bbdd por si nosotros lo tenemos con un nombre diferente y ademas le podemos añadir
//la propiedad de que lo pueda convertir en null