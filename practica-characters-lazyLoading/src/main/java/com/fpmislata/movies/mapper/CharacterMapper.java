package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.character.CharacterCreateWEB;
import com.fpmislata.movies.controller.model.character.CharacterListWEB;
import com.fpmislata.movies.domain.entity.Actor;
import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.persistence.model.ActorEntity;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import lombok.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper(componentModel = "spring")  //Permite que Spring sea capaz de administrar esta clase
public interface CharacterMapper {

    CharacterMapper mapper = Mappers.getMapper(CharacterMapper.class);

    @Mapping(target ="actor", expression = "java(mapActorIdToActor(characterCreateWEB.getActorId()))")
    Character toCharacter(CharacterCreateWEB characterCreateWEB);
    default Actor mapActorIdToActor(Integer actorId) {
        Actor actor = new Actor();
        actor.setId(actorId);
        return actor;
    }


    @Mapping(target = "actorEntity", expression = "java(ActorMapper.mapper.toActorEntity(character.getActor()))")
    CharacterEntity toCharacterEntity(Character character);

    @Mapping(target = "actor", expression = "java(mapActorEntityToActor(characterEntity.getActorEntity()))")
    Character toCharacter(CharacterEntity characterEntity);
    @Named("actorEntityToActor")
    default Actor mapActorEntityToActor(ActorEntity actorEntity){
        return  ActorMapper.mapper.toActor(actorEntity);
    }

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"characters\"))")
    //@Mapping(target = "actorEntity", expression = "java(ActorMapper.mapper.toActorEntity(actorEntity.getActor()))")
    CharacterEntity toCharacterEntity(ResultSet resultSet) throws SQLException;

    @Mapping(target = "actorId", expression="java(character.getActor().getId())")
    @Mapping(target = "actorName", expression="java(character.getActor().getName())")
    @Mapping(target = "character", expression = "java(character.getName())")
    CharacterListWEB toCharacterListWEB(Character character);

}
