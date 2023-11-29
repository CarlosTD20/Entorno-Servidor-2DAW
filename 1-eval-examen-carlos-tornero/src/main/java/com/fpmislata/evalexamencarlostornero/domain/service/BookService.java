package com.fpmislata.evalexamencarlostornero.domain.service;

import com.fpmislata.evalexamencarlostornero.domain.entity.Book;

import java.util.List;

public interface BookService {
    public List<Book> findAll();
    public Book findByIsbn(String isbn);
}
