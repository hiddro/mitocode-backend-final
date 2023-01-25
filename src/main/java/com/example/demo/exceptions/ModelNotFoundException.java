package com.example.demo.exceptions;

//@ResponseStatus(HttpStatus.NOT_FOUND) en caso se requiera por defecto sin necesidad de configurar
public class ModelNotFoundException extends RuntimeException{

    public ModelNotFoundException(String message) {
        super(message);
    }
}
