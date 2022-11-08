package com.project.autoparkweb.utill.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final String LOGIN_PROC_URL = "/login";
	private static final String LOGIN_FAILURE_URL = "/login?error";
	private static final String LOGIN_URL = "/login";
	private static final String LOGOUT_SUCCESS_URL = "/login";
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Not using Spring CSRF here to be able to use plain HTML for the login page
		http.csrf().disable()
		    /**
		     *  Register our CustomRequestCache, that saves unauthorized access attempts
		     *  so the user is redirected after login.
		     */
		    .requestCache().requestCache(new CustomRequestCache())
		    // Restrict access to our application
		    .and().authorizeRequests()
		    // Allow all vaadin internal requests
		    .requestMatchers(SecurityUtils::isFrameworkInternakRequest).permitAll()
		    // Allow all requests by logged in users
		    .anyRequest().authenticated()
		    // Configure the login page
		    .and().formLogin()
		    .loginPage(LOGIN_URL).permitAll()
		    .loginProcessingUrl(LOGIN_PROC_URL)
		    .failureUrl(LOGIN_FAILURE_URL)
		    .and().logout().logoutSuccessUrl(LOGOUT_SUCCESS_URL);
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user")
		                       .password("{noop}1111")
		                       .roles("USER")
		                       .build();
		UserDetails user2 = User.withUsername("Rollcorn")
		    .password("{noop}1221")
		    .roles("ADMIN")
		    .build();
		UserDetails user3 =User.withUsername("Maria")
				    .password("{noop}12212")
				    .roles("ADMIN")
				    .build();
		return new InMemoryUserDetailsManager(user, user2, user3);
	}
	
	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers(
				"/VAADIN/**", "/favicon.ico", "/robots.txt", "/manifest.webmanifest",
				"/sw.js", "/offline.html", "/offline.html", "/icons/**", "/images/**", "/styles/**",
				"/h2-console/**");
	}
}

