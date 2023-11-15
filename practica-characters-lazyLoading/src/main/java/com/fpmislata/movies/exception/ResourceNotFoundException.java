package com.fpmislata.movies.exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String mesage){
        super(mesage);
    }
}
