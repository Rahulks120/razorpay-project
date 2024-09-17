package com.ivoyant.project.ivo_internshub.exceptions;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class CustomExceptionObject {
    private int statusCode;

    private String message;
}
