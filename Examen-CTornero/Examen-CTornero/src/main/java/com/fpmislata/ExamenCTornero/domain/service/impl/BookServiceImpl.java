package com.fpmislata.ExamenCTornero.domain.service.impl;

import com.fpmislata.ExamenCTornero.domain.entity.Author;
import com.fpmislata.ExamenCTornero.domain.entity.Book;
import com.fpmislata.ExamenCTornero.domain.entity.Publisher;
import com.fpmislata.ExamenCTornero.domain.repository.AuthorRepository;
import com.fpmislata.ExamenCTornero.domain.repository.BookRepository;
import com.fpmislata.ExamenCTornero.domain.repository.PublisherRepository;
import com.fpmislata.ExamenCTornero.domain.service.BookService;
import com.fpmislata.ExamenCTornero.presistence.model.BookEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.fpmislata.ExamenCTornero.validation.Validation.validate;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.getAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn).orElseThrow( () -> new RuntimeException("No se encontro ningún lirbo con el isbn: " + isbn));
    }

    @Override
    public List<Book> findBYPublisherId(int publisherId) {
        return bookRepository.findByPublisherId(publisherId);
    }


    private Book save(Book book, int publisherId){
        Publisher publisher = publisherRepository.findByID(publisherId).orElseThrow( () -> new RuntimeException("No se encontro ningún Publisher con el id: " + publisherId));
        book.setPublisher(publisher);
        validate(book);
        return bookRepository.save(book);
    }

    @Override
    public Book insert(Book book, int publisherId) {
        return save(book,publisherId);
    }

    @Override
    public Book update(Book book, int publisherId) {
        return save(book, publisherId);
    }

    @Override
    public void delete(int id) {
        Book book = bookRepository.findById(id).orElseThrow( () -> new RuntimeException("No se ha encontrado ningún libro con el id: " + id));
        bookRepository.delete(book);
    }

    @Override
    public Book insertAuthor(String isbn, int authorID) {
        Book book = bookRepository.findByIsbn(isbn).orElseThrow(() -> new RuntimeException("No se ha encontrado ningún libro con el isbn: " + isbn));
        Author author = authorRepository.findById(authorID).orElseThrow(() -> new RuntimeException("No se ha encontrado ningún autor con el id: " + authorID));
        book.addAuthors(author);
        return save(book,book.getPublisher().getId());
    }


}
