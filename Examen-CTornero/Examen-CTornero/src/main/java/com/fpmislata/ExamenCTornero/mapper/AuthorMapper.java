package com.fpmislata.ExamenCTornero.mapper;

import com.fpmislata.ExamenCTornero.controller.model.author.AuthorListWeb;
import com.fpmislata.ExamenCTornero.domain.entity.Author;
import com.fpmislata.ExamenCTornero.presistence.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorMapper mapper = Mappers.getMapper(AuthorMapper.class);

    List<AuthorListWeb> toAuthorListWebList(List<Author> authors);

    List<Author> toAuthorList(List<AuthorEntity> authorEntities);

    Author toAuthor(AuthorEntity authorEntity);

    List<AuthorEntity> toAuthorEntity(List<Author> authorList);
}
