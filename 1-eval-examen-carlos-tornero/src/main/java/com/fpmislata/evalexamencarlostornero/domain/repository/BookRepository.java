package com.fpmislata.evalexamencarlostornero.domain.repository;

import com.fpmislata.evalexamencarlostornero.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    public List<Book> findAll();
    public Optional<Book> findByIsbn(String isbn);
}

