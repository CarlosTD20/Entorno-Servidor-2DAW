package com.fpmislata.ExamenCTornero.controller.model.book;

import com.fpmislata.ExamenCTornero.controller.model.publisher.PublisherWeb;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookCreateWeb {

    private String isbn;
    private String title;
    private String synopsis;
    private float price;
    private String cover;
    private int publisherId;
    private int authorsId;
}
