package de.amit.battlequest.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import de.amit.battlequest.user.controller.cors.CorsConfig;

@SpringBootApplication
@ComponentScan(basePackages = { "de.amit.battlequest.user.controller", "de.amit.battlequest.user.service" })
@Import(CorsConfig.class)
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}