package com.fpmislata.ExamenCTornero.domain.entity;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.util.List;

public class Book {

    private int id;
    private String isbn;
    private String title;
    private String synopsis;
    @DecimalMin(value = "5.00", message = "El precio debe ser mayor o igual a 5.00")
    @DecimalMax(value = "25.00", message = "El precio debe ser menor o igual a 25.00")
    private float price;
    private String cover;
    private Publisher publisher;
    private List<Author> authors;

    public Book() {
    }


    public Book(int id, String isbn, String title, String synopsis, float price, String cover, Publisher publisher, List<Author> authors) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.cover = cover;
        this.publisher = publisher;
        this.authors = authors;
    }

    public Book(String isbn, String title, String synopsis, float price, String cover, Publisher publisher, List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.synopsis = synopsis;
        this.price = price;
        this.cover = cover;
        this.publisher = publisher;
        this.authors = authors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Author> getAuthors() {
        return authors;
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
                ", price=" + price +
                ", cover='" + cover + '\'' +
                ", publisher=" + publisher +
                ", authors=" + authors +
                '}';
    }
}
