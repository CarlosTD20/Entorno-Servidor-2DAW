package com.fpmislata.ExamenCTornero.mapper;

import com.fpmislata.ExamenCTornero.controller.model.book.BookCreateWeb;
import com.fpmislata.ExamenCTornero.controller.model.book.BookDetailWeb;
import com.fpmislata.ExamenCTornero.controller.model.book.BookListWeb;
import com.fpmislata.ExamenCTornero.controller.model.book.BookUpdateWeb;
import com.fpmislata.ExamenCTornero.domain.entity.Book;
import com.fpmislata.ExamenCTornero.presistence.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookMapper mapper = Mappers.getMapper(BookMapper.class);

    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "authors", ignore = true)
    Book toBook(BookUpdateWeb bookUpdateWeb);

    @Mapping(target = "publisher", ignore = true)
    @Mapping(target = "authors", ignore = true)
    Book toBook(BookCreateWeb bookCreateWeb);

    @Mapping(target = "publisherEntity", expression = "java(PublisherMapper.mapper.toPublisherEntity(book.getPublisher()))")
    @Mapping(target = "authorEntities", expression = "java(AuthorMapper.mapper.toAuthorEntity(book.getAuthors()))")
    BookEntity toBookEntity(Book book);

    @Mapping(target = "publisherWeb", expression = "java(PublisherMapper.mapper.toPublisherListWeb(book.getPublisher()))")
    @Mapping(target = "authorListWebs", expression = "java(AuthorMapper.mapper.toAuthorListWebList(book.getAuthors()))")
    BookDetailWeb toBookDetailWeb(Book book);

    @Mapping(target = "publisher", expression = "java(PublisherMapper.mapper.toPublisher(bookEntity.getPublisherEntity()))")
    @Mapping(target = "authors", expression = "java(AuthorMapper.mapper.toAuthorList(bookEntity.getAuthorEntities()))")
    Book toBook(BookEntity bookEntity);


    BookListWeb toBookListWeb(Book books);

    @Mapping(target = "publisherEntity", ignore = true)
    @Mapping(target = "authorEntities", ignore = true)
    List<Book> toBookList(List<BookEntity> bookEntities);

}
