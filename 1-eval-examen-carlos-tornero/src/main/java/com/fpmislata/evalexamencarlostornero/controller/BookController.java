package com.fpmislata.evalexamencarlostornero.controller;

import com.fpmislata.evalexamencarlostornero.controller.model.book.BookListWeb;
import com.fpmislata.evalexamencarlostornero.domain.entity.Book;
import com.fpmislata.evalexamencarlostornero.domain.service.BookService;
import com.fpmislata.evalexamencarlostornero.http_response.Response;
import com.fpmislata.evalexamencarlostornero.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/books")
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public Response findAll(){
        List<Book> books = bookService.findAll();
        List<BookListWeb> bookListWebs = books.stream()
                .map(book -> BookMapper.mapper.toBookListWeb(book))
                .toList();
        return new Response(bookListWebs);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{isbn}")
    public Response findByIsbn(@PathVariable("isbn") String isbn){
        return new Response(BookMapper.mapper.toBookDetailWeb(bookService.findByIsbn(isbn)));
    }
}
