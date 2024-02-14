package com.fpmislata.ExamenCTornero.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public String indx(){ return "Examen Carlos Tornero 2 Trimestre"; }
}
