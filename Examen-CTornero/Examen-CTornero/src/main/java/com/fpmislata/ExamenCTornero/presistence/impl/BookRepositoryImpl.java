package com.fpmislata.ExamenCTornero.presistence.impl;

import com.fpmislata.ExamenCTornero.domain.entity.Book;
import com.fpmislata.ExamenCTornero.domain.repository.BookRepository;
import com.fpmislata.ExamenCTornero.mapper.BookMapper;
import com.fpmislata.ExamenCTornero.presistence.dao.BookDAO;
import com.fpmislata.ExamenCTornero.presistence.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepositoryImpl implements BookRepository {

    @Autowired
    BookDAO bookDAO;

    @Override
    public List<Book> getAll() {
        List<BookEntity> bookEntities = bookDAO.findAll();
        return BookMapper.mapper.toBookList(bookEntities);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        BookEntity bookEntity = bookDAO.findByIsbn(isbn);
        if (bookEntity == null){
            return Optional.empty();
        }
        return Optional.ofNullable(BookMapper.mapper.toBook(bookEntity));
    }

    @Override
    public Optional<Book> findById(int id) {
        BookEntity bookEntity = bookDAO.findById(id).get();
        return Optional.ofNullable(BookMapper.mapper.toBook(bookEntity));
    }

    @Override
    public List<Book> findByPublisherId(int publisherId) {
        List<BookEntity> bookEntity = bookDAO.findByPublisherEntityId(publisherId);
        return BookMapper.mapper.toBookList(bookEntity);
    }

    @Override
    public Book save(Book book) {
        BookEntity bookEntity = bookDAO.save(BookMapper.mapper.toBookEntity(book));
        return BookMapper.mapper.toBook(bookEntity);
    }

    @Override
    public void delete(Book book) {
        bookDAO.delete(BookMapper.mapper.toBookEntity(book));
    }
}
