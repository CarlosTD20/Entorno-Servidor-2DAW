package com.fpmislata.evalexamencarlostornero.domain.service.impl;

import com.fpmislata.evalexamencarlostornero.domain.entity.Book;
import com.fpmislata.evalexamencarlostornero.domain.repository.BookRepository;
import com.fpmislata.evalexamencarlostornero.domain.service.BookService;
import com.fpmislata.evalexamencarlostornero.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book findByIsbn(String isbn) {
        Book book = bookRepository.findByIsbn(isbn).orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + isbn));
        return book;
    }
}
