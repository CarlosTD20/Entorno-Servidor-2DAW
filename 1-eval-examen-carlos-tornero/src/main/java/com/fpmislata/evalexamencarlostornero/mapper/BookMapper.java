package com.fpmislata.evalexamencarlostornero.mapper;

import com.fpmislata.evalexamencarlostornero.controller.model.author.AuthorListWeb;
import com.fpmislata.evalexamencarlostornero.controller.model.book.BookDetailWeb;
import com.fpmislata.evalexamencarlostornero.controller.model.book.BookListWeb;
import com.fpmislata.evalexamencarlostornero.domain.entity.Author;
import com.fpmislata.evalexamencarlostornero.domain.entity.Book;
import com.fpmislata.evalexamencarlostornero.domain.repository.BookRepository;
import com.fpmislata.evalexamencarlostornero.persistence.model.AuthorEntity;
import com.fpmislata.evalexamencarlostornero.persistence.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper mapper = Mappers.getMapper(BookMapper.class);

    BookListWeb toBookListWeb(Book book);


    @Mapping(target = "authorListWebs",expression = "java(mapAuthorsToAuthorsListWeb(book.getAuthors()))")
    BookDetailWeb toBookDetailWeb(Book book);
    @Named("AuthorsToAuthorListWeb")
    default List<AuthorListWeb> mapAuthorsToAuthorsListWeb(List<Author> authors){
        if (authors == null){
            return  null;
        }
        return authors.stream()
                .map(AuthorMapper.mapper::toAuthorListWeb)
                .toList();
    }


    @Mapping(target = "publisher", expression = "java(PublisherMapper.mapper.toPublisher(bookEntity.getPublisherEntity()))")
    @Mapping(target = "authors", expression = "java(mapAuthorEntitiesToAuthor(bookEntity.getAuthorEntities()))" )
    Book toBook(BookEntity bookEntity);
    @Named("authorsEntitiestoAuthors")
    default List<Author> mapAuthorEntitiesToAuthor(List<AuthorEntity> authorEntities){
        if (authorEntities == null){
            return null;
        }
        return authorEntities.stream()
                .map(AuthorMapper.mapper::toAuthor)
                .toList();
    }

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "isbn", expression = "java(resultSet.getString(\"isbn\"))")
    @Mapping(target = "title", expression = "java(resultSet.getString(\"title\"))")
    @Mapping(target = "synopsis", expression = "java(resultSet.getString(\"synopsis\"))")
    //po@Mapping(target = "id", expression = "java(resultSet.getInt(\"id_publisher\"))")
    BookEntity toBookEntity(ResultSet resultSet) throws SQLException;
}
