package com.example.Bootcamp.SinauKoding;

import com.example.Bootcamp.SinauKoding.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import springfox.documentation.spi.service.contexts.SecurityContext;

@SpringBootApplication
public class BootcampSinauKodingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampSinauKodingApplication.class, args);
	}

	public static User session(){
		return (User) SecurityContextHolder.getContext().getAuthentication();
	}

}
