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

    private ResponseEntity<CustomExceptionObject> buildResponseEntity(Exception e, HttpStatus status) {
        customObject.setMessage(e.getMessage());
        customObject.setStatusCode(status.value());
        return ResponseEntity.status(status).body(customObject);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<CustomExceptionObject> handleEmployeeNotFoundException(Exception e) {
        return buildResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AnnouncementNotFoundException.class)
    public ResponseEntity<CustomExceptionObject> handleAnnouncementNotFoundException(Exception e) {
        return buildResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HolidayNotFoundException.class)
    public ResponseEntity<CustomExceptionObject> handleHolidayNotFoundException(Exception e) {
        return buildResponseEntity(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EmployeeIdAlreadyExistsException.class)
    public ResponseEntity<CustomExceptionObject> handleEmployeeIdAlreadyExistsException(Exception e) {
        return buildResponseEntity(e, HttpStatus.BAD_REQUEST);
    }


}
