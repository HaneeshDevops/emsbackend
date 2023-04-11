package com.cg.ems.configuration;

import org.springframework.context.annotation.Bean;
//import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.util.pattern.PathPattern;


@Configuration
public class CorsConfiguration {

	private static final String GET ="GET";
	private static final String POST ="POST";
	private static final String PUT ="PUT";
	private static final String DELETE ="DELETE";
	//protected String pathPattern;
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			
			public void addCorsMappings(CorsRegistry registry) {
				//String pathPattern;
				registry.addMapping("/**")
				.allowedMethods(GET, PUT, POST, DELETE)
				.allowedHeaders("*")
				.allowedOriginPatterns("*")
				.allowCredentials(true);
				
			}

		};
	}
}
