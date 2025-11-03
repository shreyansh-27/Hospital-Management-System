package com.meow.hospitalmanagementsystem.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException {

  private final HttpStatus httpStatus;

  public AppException(String message, HttpStatus status) {
    super(message);
    httpStatus = status;
  }
}
