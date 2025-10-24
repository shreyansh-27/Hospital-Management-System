package com.meow.hospitalmanagementsystem.exception;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends AppException{
    public UnauthorizedException(String message, HttpStatus status) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
