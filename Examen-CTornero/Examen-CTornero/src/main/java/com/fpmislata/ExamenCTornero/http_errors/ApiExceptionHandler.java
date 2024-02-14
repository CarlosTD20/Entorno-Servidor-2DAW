package com.fpmislata.ExamenCTornero.http_errors;


import com.fpmislata.ExamenCTornero.exception.ResourceNotFoundException;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {

    // Maneja excepciones de tipo ResourceNotFoundException
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({
            ResourceNotFoundException.class
    })
    @ResponseBody
    public ErrorMessage notFoundRequest(Exception exception) {
        return new ErrorMessage(exception.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler({
            Exception.class
    })

    @ResponseBody
    public ErrorMessage badRequest(Exception exception) {
        return new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            ValidationException.class
    })
    @ResponseBody
    public ErrorMessage exception(Exception exception) {
        return new ErrorMessage(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ErrorMessage badRequest(HttpMessageNotReadableException exception) {
        return new ErrorMessage("Invalid request body", HttpStatus.BAD_REQUEST.value());
    }
}
