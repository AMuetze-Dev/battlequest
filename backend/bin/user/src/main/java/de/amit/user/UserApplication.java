package de.amit.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import de.amit.user.controller.cors.CorsConfig;

@SpringBootApplication
@ComponentScan(basePackages = { "de.amit.user.controller", "de.amit.user.service" })
@Import(CorsConfig.class)
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
