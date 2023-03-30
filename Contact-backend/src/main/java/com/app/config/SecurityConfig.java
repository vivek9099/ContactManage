package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig  {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		return http
				.csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
				.authorizeRequests(auth -> auth
						.requestMatchers("/api/contacts").permitAll()
						.anyRequest().authenticated())
				  .headers(headers-> headers.frameOptions().sameOrigin())
				 .build();
		
	}
	
	
	

}
