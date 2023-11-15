package com.fpmislata.movies.persistence.model;

import com.fpmislata.movies.persistence.dao.ActorsDAO;
import com.fpmislata.movies.persistence.dao.DirectorsDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieEntity {
    private int id;
    private String title;
    private int year;
    private int runtime;
    private int directorId;
    private List<Integer> charactersId;
    //private List<Integer> actorIds;

    private DirectorEntity directorEntity;
    private List<CharacterEntity> characterEntities;

    public MovieEntity(int id, String title, int year, int runtime) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
    }

/*
    public DirectorEntity getDirectorsByMovieId(Connection connection, DirectorsDAO directorsDAO){
        if (this.directorEntity == null){
            this.directorEntity = directorsDAO.findDirectorByMovieId(connection,this.id).orElse(null);
        }
        return this.directorEntity;
    }

    public List<ActorEntity> getActorsByMovieId(Connection connection, ActorsDAO actorsDAO){
        if (this.actorEntities == null){
            this.actorEntities = actorsDAO.findActorsByMovieID(connection,this.id);
        }
        return this.actorEntities;
    }
 */
}
