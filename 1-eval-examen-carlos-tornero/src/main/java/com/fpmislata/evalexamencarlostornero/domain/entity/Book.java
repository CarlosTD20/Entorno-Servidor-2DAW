package com.fpmislata.evalexamencarlostornero.domain.entity;


import java.util.List;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private String synopsis;
    private Publisher publisher;
    private List<Author> authors;

    public Book(){

    }

    public Book(String isbn, String title, String synopsis, Publisher publisher, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.publisher = publisher;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }
}
