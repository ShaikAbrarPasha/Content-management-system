package com.example.cms.utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDoc {

	Contact contact() {
		return new Contact().email("shussainoffcial@gmail.com").name("S.Hussain").url("www.devhussain.com");
	}
		
		@Bean
		Info info() {
			return new Info ().title("Content Management System")
					.description("RESTful API for Content Management System ")
					.version("v1");
		}
		
		@Bean
		OpenAPI openAPI() {
			return new OpenAPI().info(info().contact(contact()));
		}
}
