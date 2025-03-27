package com.example.userapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Usuarios")
                        .version("1.0.0")
                        .description("API REST para gestionar autenticación con JWT")
                        .contact(new Contact()
                                .name("Stefanini")
                                .email("alansa2@illinios.com")));
    }
}