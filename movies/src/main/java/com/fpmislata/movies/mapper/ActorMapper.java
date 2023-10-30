package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.actor.ActorCreateWEB;
import com.fpmislata.movies.controller.model.actor.ActorDetailWEB;
import com.fpmislata.movies.controller.model.actor.ActorListWEB;
import com.fpmislata.movies.controller.model.actor.ActorUpdateWEB;
import com.fpmislata.movies.domain.entity.Actor;

import com.fpmislata.movies.persistence.model.ActorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper mapper = Mappers.getMapper(ActorMapper.class);

    Actor toActor(ActorCreateWEB actorCreateWEB);
    Actor toActor(ActorUpdateWEB actorUpdateWEB);

    ActorListWEB toActorListWEB(Actor actor);
    ActorDetailWEB toActorDetailWEB(Actor actor);

    ActorEntity toActorEntity(ResultSet resultSet);
}
