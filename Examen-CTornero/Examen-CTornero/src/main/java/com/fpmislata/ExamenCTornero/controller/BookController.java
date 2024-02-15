package com.fpmislata.ExamenCTornero.controller;

import com.fpmislata.ExamenCTornero.controller.model.book.BookCreateWeb;
import com.fpmislata.ExamenCTornero.controller.model.book.BookDetailWeb;
import com.fpmislata.ExamenCTornero.controller.model.book.BookListWeb;
import com.fpmislata.ExamenCTornero.controller.model.book.BookUpdateWeb;
import com.fpmislata.ExamenCTornero.domain.entity.Book;
import com.fpmislata.ExamenCTornero.domain.service.BookService;
import com.fpmislata.ExamenCTornero.http_response.Response;
import com.fpmislata.ExamenCTornero.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/weblibreria")
public class BookController {

    @Autowired
    BookService bookService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/books")
    public Response getAll(){
        List<Book> books = bookService.getAll();
        List<BookListWeb> bookListWebs = books.stream()
                .map(book -> BookMapper.mapper.toBookListWeb(book))
                .toList();
        return new Response(bookListWebs);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/books/{isbn}")
    public Response findByIsbn(@PathVariable("isbn") String isbn){
        BookDetailWeb bookDetailWeb = BookMapper.mapper.toBookDetailWeb(bookService.findByIsbn(isbn));
        return new Response(bookDetailWeb);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/publisher/{id}/books")
    public Response findBIPublisherId(@PathVariable("id") int id){
        List<Book> books = bookService.findBYPublisherId(id);
        List<BookListWeb> bookListWebs = books.stream()
                .map(book -> BookMapper.mapper.toBookListWeb(book))
                .toList();
        return new Response(bookListWebs);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/books")
    public Response insert(@RequestBody BookCreateWeb bookCreateWeb){
        Book book = bookService.insert(BookMapper.mapper.toBook(bookCreateWeb),bookCreateWeb.getPublisherId());
        return new Response(BookMapper.mapper.toBookDetailWeb(book));
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("/books/{id}")
    public Response update(@PathVariable("id") int id, @RequestBody BookUpdateWeb bookUpdateWeb){
        bookUpdateWeb.setId(id);
        Book book = bookService.update(BookMapper.mapper.toBook(bookUpdateWeb),bookUpdateWeb.getPublisherId());
        return new Response(BookMapper.mapper.toBookDetailWeb(book));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/books/{id}")
    public void delete(@PathVariable("id") int id){
        bookService.delete(id);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/books/{isbn}/authors")
    public Response insertAuthor(@PathVariable("isbn") String isbn, @RequestBody Map<String, Integer> requestBody){
        int authorId = requestBody.get("authorId");
        Book book = bookService.insertAuthor(isbn,authorId);
        return new Response(BookMapper.mapper.toBookDetailWeb(book));
    }
}
