package com.fpmislata.movies.persistence.model;

import com.fpmislata.movies.persistence.dao.ActorsDAO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Connection;

@Getter
@Setter
@NoArgsConstructor
public class CharacterEntity {
    private int id;
    private String name;
    ActorEntity actorEntity;

    public CharacterEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ActorEntity getActorEntityByMovieId(Connection connection, ActorsDAO actorsDAO){
        if (this.actorEntity == null){
            this.actorEntity = actorsDAO.getByCharacterId(connection,this.id).orElse(null);
        }
        return this.actorEntity;
    }
}
