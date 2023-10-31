package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.actor.ActorCreateWEB;
import com.fpmislata.movies.controller.model.actor.ActorDetailWEB;
import com.fpmislata.movies.controller.model.actor.ActorListWEB;
import com.fpmislata.movies.controller.model.actor.ActorUpdateWEB;
import com.fpmislata.movies.domain.entity.Actor;

import com.fpmislata.movies.persistence.model.ActorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper mapper = Mappers.getMapper(ActorMapper.class);

    ActorEntity toActorEntity(Actor actor);
    Actor toActor(ActorEntity actorEntity);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"name\"))")
    @Mapping(target = "birthYear", expression = "java(resultSet.getInt(\"birthYear\"))")
    @Mapping(target = "deathYear", expression = "java((resultSet.getObject(\"deathYear\") != null) ? resultSet.getInt(\"deathYear\"):null)")
    ActorEntity toActorEnity(ResultSet resultSet) throws SQLException;

    Actor toActor(ActorCreateWEB actorCreateWEB);
    Actor toActor(ActorUpdateWEB actorUpdateWEB);

    ActorListWEB toActorListWEB(Actor actor);
    ActorDetailWEB toActorDetailWEB(Actor actor);

    ActorEntity toActorEntity(ResultSet resultSet);
}
