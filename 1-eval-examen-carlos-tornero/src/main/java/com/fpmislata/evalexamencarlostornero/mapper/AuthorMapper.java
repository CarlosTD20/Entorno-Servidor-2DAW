package com.fpmislata.evalexamencarlostornero.mapper;

import com.fpmislata.evalexamencarlostornero.controller.model.author.AuthorListWeb;
import com.fpmislata.evalexamencarlostornero.domain.entity.Author;
import com.fpmislata.evalexamencarlostornero.domain.entity.Book;
import com.fpmislata.evalexamencarlostornero.persistence.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper mapper = Mappers.getMapper(AuthorMapper.class);


    AuthorListWeb toAuthorListWeb(Author author);

    Author toAuthor(AuthorEntity authorEntity);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"name\"))")
    @Mapping(target = "nationality", expression = "java(resultSet.getString(\"nationality\"))")
    @Mapping(target = "birth_year", expression = "java(resultSet.getInt(\"birth_year\"))")
    @Mapping(target = "death_year", expression = "java(resultSet.getInt(\"death_year\"))")
    AuthorEntity toAuthorEntity(ResultSet resultSet) throws SQLException;
}
