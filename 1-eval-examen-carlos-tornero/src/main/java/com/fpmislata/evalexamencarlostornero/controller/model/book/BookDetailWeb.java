package com.fpmislata.evalexamencarlostornero.controller.model.book;

import com.fpmislata.evalexamencarlostornero.controller.model.author.AuthorListWeb;
import com.fpmislata.evalexamencarlostornero.controller.model.publisher.PublisherWeb;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailWeb {
    private String isbn;
    private String title;
    private String synopsis;
    private PublisherWeb publisherWeb;
    private List<AuthorListWeb> authorListWebs;
}
