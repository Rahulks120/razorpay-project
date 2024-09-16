package com.ivoyant.project.ivo_internshub.exceptions;

public class HolidayNotFoundException extends RuntimeException {
    public HolidayNotFoundException(Long id) {
        super("Holiday not found with ID:" + id);
    }
}
