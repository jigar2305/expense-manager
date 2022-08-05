package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class ExpManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpManagerApplication.class, args);
	}
	@Bean
	public OpenAPI myapi() {
		return new OpenAPI().info(
				new Info().title("22-ism-boot").version("1.0")
				.description("spring boot demo")
				.termsOfService("http://google.com/")
				.license(new License().name("Free :D").url("http://free.com")));
		
	}

}
