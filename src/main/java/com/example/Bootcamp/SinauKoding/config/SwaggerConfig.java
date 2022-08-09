package com.example.Bootcamp.SinauKoding.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()))
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

    //Menambahkan authorize pada swagger
    private SecurityScheme securityScheme() {
        return new ApiKey("Token", "Authorization", "header");
    }
    //untuk configurasi security(authorization) swagger
    private SecurityContext securityContext(){
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    //configurasi untuk menentukan scope / batas pada authorized swagger
    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");

        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Token", authorizationScopes));
    }
}
