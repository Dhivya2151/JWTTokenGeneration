package com.predfut.demospringsecurity.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.authentication.AuthenticationProviderBeanDefinitionParser;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.predfut.demospringsecurity.Service.JwtFilterService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	UserDetailsService myUserDetailsService;
	@Autowired
	JwtFilterService jwtFilterService;
	
	
	@Bean
	public SecurityFilterChain filterchaining(HttpSecurity  http) throws Exception
	{
		return http.csrf(Customizer->Customizer.disable())
		.authorizeHttpRequests(request->request.requestMatchers("Register","login").permitAll()
				
				.anyRequest().authenticated())
//		.formLogin(Customizer.withDefaults())
		.httpBasic(Customizer.withDefaults())
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(jwtFilterService, UsernamePasswordAuthenticationFilter.class)
				.build();
		
	}
	
	
	
	
	@Bean
	public PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
		
	}
	
//	 @Bean
//	 public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//		    
//			return http.getSharedObject(AuthenticationManagerBuilder.class)
//		            .userDetailsService(myUserDetailsService)   // 🔁 Spring-ku DB-lendu user edukka solludhu
//		            .passwordEncoder(encoder())               // 🔐 Password match panna encoder
//		           .and().build();
//		}

	
	 @Bean
     public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
    	 return configuration.getAuthenticationManager();
}
}
