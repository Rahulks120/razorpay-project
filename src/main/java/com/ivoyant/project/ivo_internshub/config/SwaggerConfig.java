package com.ivoyant.project.ivo_internshub.config;

import io.swagger.v3.oas.models.OpenAPI;

import io.swagger.v3.oas.models.info.Info;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

@Configuration

public class
SwaggerConfig {
    @Bean

    public OpenAPI myOpenApi() {
        Info info = new Info()
                .title("ivo-internshub")
                .description("A user-friendly API for managing employees, processing salaries, and generating payroll reports.")
                .version("1.0.0");

        return new OpenAPI().info(info);
    }
}