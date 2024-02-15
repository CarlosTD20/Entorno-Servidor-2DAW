package com.fpmislata.ExamenCTornero.domain.service;

import com.fpmislata.ExamenCTornero.domain.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public List<Book> getAll();
    public Book findByIsbn(String isbn);
    public List<Book> findBYPublisherId(int publisherId);
    public Book insert(Book book, int publisherId);
    public Book update(Book book, int publisherId);
    public void delete(int id);
    public Book insertAuthor(String isbn, int authorID);
}
