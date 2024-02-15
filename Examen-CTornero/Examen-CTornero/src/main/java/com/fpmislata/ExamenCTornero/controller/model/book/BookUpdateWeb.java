package com.fpmislata.ExamenCTornero.controller.model.book;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BookUpdateWeb {
    private int id;
    private String isbn;
    private String title;
    private String synopsis;
    private float price;
    private String cover;
    private int publisherId;
    private List<Integer> authorsId;
}
