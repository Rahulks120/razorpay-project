package com.ivoyant.project.ivo_internshub.exceptions;

public class EmployeeIdAlreadyExistsException extends RuntimeException {
    public EmployeeIdAlreadyExistsException(String str) {
        super(str);
    }
}
