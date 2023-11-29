package com.fpmislata.evalexamencarlostornero.persistence.impl;

import com.fpmislata.evalexamencarlostornero.db.DBUtil;
import com.fpmislata.evalexamencarlostornero.domain.entity.Book;
import com.fpmislata.evalexamencarlostornero.domain.repository.BookRepository;
import com.fpmislata.evalexamencarlostornero.mapper.BookMapper;
import com.fpmislata.evalexamencarlostornero.persistence.dao.AuthorDAO;
import com.fpmislata.evalexamencarlostornero.persistence.dao.BookDAO;
import com.fpmislata.evalexamencarlostornero.persistence.dao.PublisherDAO;
import com.fpmislata.evalexamencarlostornero.persistence.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    BookDAO bookDAO;
    @Autowired
    AuthorDAO authorDAO;
    @Autowired
    PublisherDAO publisherDAO;

    @Override
    public List<Book> findAll() {
        try (Connection connection = DBUtil.getConnection(true)){
            List<BookEntity> bookEntities = bookDAO.findAllBooks(connection);
            List<Book> books = bookEntities.stream()
                    .map(bookEntity -> BookMapper.mapper.toBook(bookEntity))
                    .toList();
            return books;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        try (Connection connection = DBUtil.getConnection(true)){
            BookEntity bookEntity = bookDAO.findByIsbn(connection,isbn).get();
            if (bookEntity != null){
                bookEntity.getPublisherEntity(connection,publisherDAO);
                bookEntity.getAuthorEntities(connection,authorDAO);
            }
            return Optional.of(BookMapper.mapper.toBook(bookEntity));
        }catch (SQLException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}
