package com.fpmislata.ExamenCTornero.domain.repository;

import com.fpmislata.ExamenCTornero.domain.entity.Book;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    public List<Book> getAll();
    public Optional<Book> findByIsbn(String isbn);
    public Optional<Book> findById(int id);
    public List<Book> findByPublisherId(int publisherId);
    public Book save(Book book);
    public void delete(Book book);
}
