package com.example.cms.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
	private CustomUserDetailsService userDetailsService;
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(12);//it is widely used and more secure of password
	}
	
     @Bean
	AuthenticationProvider authenticationProvider() {
	 DaoAuthenticationProvider provider =new DaoAuthenticationProvider();
	 provider.setPasswordEncoder(passwordEncoder());
	 provider.setUserDetailsService(userDetailsService);   //to perform database authentication ====>userrepo ===>database 
	 return provider;
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf->csrf.disable()).authorizeHttpRequests(auth->auth.requestMatchers("/users/register")
				                                                          .permitAll().anyRequest()
				                                                          .authenticated()).formLogin(Customizer.withDefaults()).build();
	}
	
}
