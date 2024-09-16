package com.ivoyant.project.ivo_internshub.exceptions;

public class AnnouncementNotFoundException extends RuntimeException {
    public AnnouncementNotFoundException(Long id) {
        super("Announcement not found with ID:" + id);
    }
}
