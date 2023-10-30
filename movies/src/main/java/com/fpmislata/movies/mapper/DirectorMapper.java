package com.fpmislata.movies.mapper;

import com.fpmislata.movies.controller.model.director.DirectorCreateWEB;
import com.fpmislata.movies.controller.model.director.DirectorDetailWEB;
import com.fpmislata.movies.controller.model.director.DirectorListWEB;
import com.fpmislata.movies.controller.model.director.DirectorUpdateWEB;
import com.fpmislata.movies.domain.entity.Director;
import com.fpmislata.movies.persistence.model.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface DirectorMapper {
    DirectorMapper mapper = Mappers.getMapper(DirectorMapper.class);

    DirectorEntity toDirectorEntity(Director director);

    Director toDirector(DirectorEntity directorEntity);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"name\"))")
    @Mapping(target = "birthYear", expression = "java(resultSet.getInt(\"birthYear\"))")
    @Mapping(target = "deathYear", expression = "java(resultSet.getInt(\"deathYear\"))")
    DirectorEntity toDirectorEntity(ResultSet resultSet) throws SQLException;

    Director toDirector(DirectorCreateWEB directorCreateWeb);
    Director toDirector(DirectorUpdateWEB directorUpdateWeb);

    DirectorListWEB toDirectorListWEB(Director director);
    DirectorDetailWEB toDirectorDetailWEB(Director director);
}
