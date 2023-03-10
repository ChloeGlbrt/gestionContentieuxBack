package com.inti.config;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.inti.service.impl.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AppUserDetailsService appUserDetailsService; // Utilisateur + Profils
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}
	// Activation : Formulaire d'authentification du projet Spring Security + la méthode BAA
	public void configure(HttpSecurity http) throws Exception{
		http // La sécurité des requêtes http
			.authorizeRequests()
				.anyRequest().permitAll() // .authenticated pour authentifier et permitAll pour afficher dans front
			.and()
			.formLogin() // formulaire login fournit par le projet Spring Security
				.permitAll()
			.and()
			.logout()
				.logoutUrl("/logout")
				.permitAll()
			.and()
			.httpBasic() // BAA
			.and()
			.csrf().disable(); // méthode d'attaque informatique (cybersécurité)
	}
	@Bean
	public FilterRegistrationBean simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();

		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*")); // GET, POST, PUT, DELETE, PATCH
		config.setAllowedHeaders(Collections.singletonList("*"));

		source.registerCorsConfiguration("/**", config);

		FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}