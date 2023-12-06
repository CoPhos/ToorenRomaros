package com.ToorenRomaros.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.data.repository.query.SecurityEvaluationContextExtension;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

//@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
//(prePostEnabled = true)
//public class ResourceServerConfig {
//
//	private final JwtAuthConverter jwtAuthConverter;
//
//	public ResourceServerConfig(JwtAuthConverter jwtAuthConverter) {
//		this.jwtAuthConverter = jwtAuthConverter;
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http
//				.httpBasic()
//				.disable()
//				.formLogin()
//				.disable();
//		http
//				.csrf()
//				.disable()
//				.authorizeHttpRequests()
//				.anyRequest()
//				.authenticated();
//		http
//				.csrf().disable()
//				.cors().and().authorizeRequests()
//				.anyRequest().permitAll();
//
//		http
//				.oauth2ResourceServer()
//				.jwt()
//				.jwtAuthenticationConverter(jwtAuthConverter);
//
//		http
//				.sessionManagement()
//				.sessionCreationPolicy(STATELESS);
//
//		return http.build();
//	}
//
//	@Bean
//	public SecurityEvaluationContextExtension securityEvaluationContextExtension() {
//	    return new SecurityEvaluationContextExtension();
//	}
//
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("*"));
//		configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//		configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
//}
