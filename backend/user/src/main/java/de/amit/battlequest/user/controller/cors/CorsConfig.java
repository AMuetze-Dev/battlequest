package de.amit.battlequest.user.controller.cors;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/lobby/**").allowedOriginPatterns("*").allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
		registry.addMapping("/user/**").allowedOriginPatterns("*").allowedMethods("GET", "POST", "PUT", "DELETE").allowCredentials(true);
	}

}