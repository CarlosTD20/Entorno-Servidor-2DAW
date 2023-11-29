package com.fpmislata.evalexamencarlostornero.mapper;

import com.fpmislata.evalexamencarlostornero.domain.entity.Publisher;
import com.fpmislata.evalexamencarlostornero.persistence.model.PublisherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface PublisherMapper {

    PublisherMapper mapper = Mappers.getMapper(PublisherMapper.class);

    Publisher toPublisher(PublisherEntity publisherEntity);

    @Mapping(target = "id" , expression =  "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"name\"))")
    PublisherEntity toPublisherEntity(ResultSet resultSet) throws SQLException;
}
