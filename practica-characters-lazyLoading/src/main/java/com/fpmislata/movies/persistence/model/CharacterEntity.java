package com.fpmislata.movies.persistence.model;

import com.fpmislata.movies.persistence.dao.ActorsDAO;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Connection;

//@Getter
//@Setter
@Data
@Entity
@Table(name = "actors_movies")
@NoArgsConstructor
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    ActorEntity actorEntity;

    public CharacterEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }
/*
    public ActorEntity getActorEntityByMovieId(Connection connection, ActorsDAO actorsDAO){
        if (this.actorEntity == null){
            this.actorEntity = actorsDAO.getByCharacterId(connection,this.id).orElse(null);
        }
        return this.actorEntity;
    }
 */
}
