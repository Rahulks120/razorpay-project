package com.ivoyant.project.ivo_internshub.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(Long id) {
        super("Employee not found with ID:" + id);
    }
}
