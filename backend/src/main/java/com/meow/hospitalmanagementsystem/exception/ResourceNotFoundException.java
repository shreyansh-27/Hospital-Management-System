package com.meow.hospitalmanagementsystem.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends AppException{
    public ResourceNotFoundException(String resource, Object id) {
        super(resource + " not found with ID: " + id, HttpStatus.NOT_FOUND);
    }
}
