package com.Jknpp.DesafioItau.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenApi() {

        return new OpenAPI()
                .info(new Info()
                        .title("Desafio Itaú Backend")
                        .version("1.0")
                        .description("API REST desenvolvida para o desafio técnico do Itaú.")
                        .contact(new Contact()
                                .name("Jairo Karnopp")
                                .url("https://github.com/Jknpp")
                        ));
    }
}