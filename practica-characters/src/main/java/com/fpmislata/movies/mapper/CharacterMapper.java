package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.character.CharacterCreateWEB;
import com.fpmislata.movies.controller.model.character.CharacterListWEB;
import com.fpmislata.movies.domain.entity.Character;
import com.fpmislata.movies.persistence.model.CharacterEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")  //Permite que Spring sea capaz de administrar esta clase
public interface CharacterMapper {

    CharacterMapper mapper = Mappers.getMapper(CharacterMapper.class);

    Character toCharacter(CharacterEntity characterEntity);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"characters\"))")
    CharacterEntity toCharacterEntity(ResultSet resultSet) throws SQLException;


    @Mapping(target = "actorId", expression="java(character.getActor().getId())")
    @Mapping(target = "actorName", expression="java(character.getActor().getName())")
    @Mapping(target = "character", expression ="java(character.getName())")
    CharacterListWEB toCharacterListWEB(Character character);

}
