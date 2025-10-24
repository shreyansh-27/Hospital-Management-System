package com.meow.hospitalmanagementsystem.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{

    private final HttpStatus httpStatus;

    public AppException(String message, HttpStatus status){
        super(message);
        httpStatus = status;
    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}
