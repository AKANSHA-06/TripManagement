package com.example.exception;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    return (new ErrorMessage(
        HttpStatus.BAD_REQUEST.value(),
        new Date(System.currentTimeMillis()),
        ex.getMessage(),
        request.getDescription(false)));
  }
  
  @ExceptionHandler(Exception.class)
  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
    return (new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(System.currentTimeMillis()),
        ex.getMessage(),
        request.getDescription(false)));
  }
}