package com.fpmislata.movies.persistence.model;

import com.fpmislata.movies.persistence.dao.ActorsDAO;
import com.fpmislata.movies.persistence.dao.CharacterDAO;
import com.fpmislata.movies.persistence.dao.DirectorsDAO;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Connection;
import java.util.List;

//@Getter
//@Setter
@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movies")
public class MovieEntity {

    @Id
    //Genera de manera automatica valores unicos para la clave primaria al insertar nuevas filas
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int year;
    private int runtime;
    //private int directorId;
    //private List<Integer> charactersId;
    //private List<Integer> actorIds;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private DirectorEntity directorEntity;
    /*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "actors_movies",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actorEntities;
     */

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private List<CharacterEntity> characterEntities;

    public MovieEntity(int id, String title, int year, int runtime) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
    }

/*
    public DirectorEntity getDirectorEntity(Connection connection, DirectorsDAO directorsDAO){
        if (this.directorEntity == null){
            this.directorEntity = directorsDAO.findDirectorByMovieId(connection,this.id).orElse(null);
        }
        return this.directorEntity;
    }

    public List<CharacterEntity> getCharacterEntities(Connection connection, CharacterDAO characterDAO){
        if (this.characterEntities == null){
            this.characterEntities = characterDAO.getByMovieId(connection, this.id);
        }
        return this.characterEntities;
    }
 */
}
