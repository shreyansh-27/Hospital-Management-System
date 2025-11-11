package com.meow.hospitalmanagementsystem.exception;

import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends AppException {
    public ResourceAlreadyExistsException(String resource) {
        super(resource + " already exists", HttpStatus.BAD_REQUEST);
    }
}
