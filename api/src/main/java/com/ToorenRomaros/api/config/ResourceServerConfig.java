package com.ToorenRomaros.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration  
@EnableWebSecurity
@EnableMethodSecurity
(prePostEnabled = true)
public class ResourceServerConfig {

	private final JwtAuthConverter jwtAuthConverter;

	public ResourceServerConfig(JwtAuthConverter jwtAuthConverter) {
		this.jwtAuthConverter = jwtAuthConverter;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
				.csrf()
				.disable()
				.authorizeHttpRequests()
				.anyRequest()
				.authenticated();

		http
				.oauth2ResourceServer()
				.jwt()
				.jwtAuthenticationConverter(jwtAuthConverter);

		http
				.sessionManagement()
				.sessionCreationPolicy(STATELESS);

		return http.build();
	}
	
	@Bean
	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
	    return new SecurityEvaluationContextExtension();
	}
}
