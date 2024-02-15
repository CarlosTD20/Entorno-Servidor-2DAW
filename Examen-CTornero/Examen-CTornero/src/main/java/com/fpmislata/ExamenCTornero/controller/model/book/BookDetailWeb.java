package com.fpmislata.ExamenCTornero.controller.model.book;

import com.fpmislata.ExamenCTornero.controller.model.author.AuthorListWeb;
import com.fpmislata.ExamenCTornero.controller.model.publisher.PublisherWeb;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookDetailWeb {
    private int id;
    private String isbn;
    private String title;
    private String synopsis;
    private float price;
    private String cover;
    private PublisherWeb publisherWeb;
    private List<AuthorListWeb> authorListWebs;
}
