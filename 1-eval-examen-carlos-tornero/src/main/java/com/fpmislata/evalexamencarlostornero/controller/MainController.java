package com.fpmislata.evalexamencarlostornero.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("")
    public String index(){
        return "Bienvenido a la API del examen de la primera evaluación";
    }
}
