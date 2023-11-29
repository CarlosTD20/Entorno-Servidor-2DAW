package com.fpmislata.evalexamencarlostornero.http_errors;

public class ErrorMessage {
    private final String message;
    private final int code;


    public ErrorMessage(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
