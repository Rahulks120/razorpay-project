package com.ivoyant.project.ivo_internshub.exceptions;

public class EmployeeIdAlreadyExistsException extends RuntimeException {
    public EmployeeIdAlreadyExistsException(Long id) {
        super("Employee already exists with ID:" + id);
    }
}
