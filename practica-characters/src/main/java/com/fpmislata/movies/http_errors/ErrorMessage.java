package com.fpmislata.movies.http_errors;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;

@Getter
public class ErrorMessage {

    private final String message;
    private final int code;


    public ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
