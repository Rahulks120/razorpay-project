package com.ivoyant.project.ivo_internshub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private final CustomExceptionObject customObject;

    public GlobalExceptionHandler(CustomExceptionObject customObject) {
        this.customObject = customObject;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomExceptionObject> handleResourceNotFoundException(Exception e) {
        customObject.setMessage(e.getMessage());
        customObject.setStatusCode(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customObject);
    }

    @ExceptionHandler(EmployeeIdAlreadyExistsException.class)
    public ResponseEntity<CustomExceptionObject> handleEmployeeIdAlreadyExistsException(Exception e) {
        customObject.setMessage(e.getMessage());
        customObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(customObject);
    }
}
