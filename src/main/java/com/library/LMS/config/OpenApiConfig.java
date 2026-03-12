package com.library.LMS.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(){

        return new OpenAPI().info(new Info()
        .title("Library Management APi")
        .version("v1.0")
        .description("REST API for LMS")
        .contact(new Contact().name("Ekesh").email("ekesh@gmail.com")));


    }
}
