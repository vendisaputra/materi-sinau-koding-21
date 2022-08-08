package com.example.Bootcamp.SinauKoding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.Bootcamp.SinauKoding"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        ApiInfo info = new ApiInfo(
                "Sinau Koding 21",
                "Api Documentation Sinau Koding 21",
                "1.0",
                "Term of service",
                contact(),
                "",
                "",
                new ArrayList<>()
        );

        return info;
    }

    private Contact contact(){
        return new Contact("Sinau Koding", "", "");
    }
}
