package com.fpmislata.ExamenCTornero.exception;

public class SQLStatmentException extends RuntimeException{
    private static final String DESCRIPTION = "Error executing SQL statment";
    public SQLStatmentException(String message) {
        super(DESCRIPTION + ". " + message);
    }
}
