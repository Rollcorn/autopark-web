package com.project.autoparkweb.utill.Security;

import com.project.autoparkweb.views.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


public class Authorization extends VaadinWebSecurityConfigurerAdapter {

    public static void main(String[] args) {  }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        setLoginView(http, LoginView.class);
    }

    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return new InMemoryUserDetailsManager(
                User.withUsername("Rollcorn")
                        .password("{noop}password")
                        .roles("ADMIN")
                        .build(),
                User.withUsername("Maria")
                        .password("{noop}password")
                        .roles("ADMIN")
                        .build()
        );
    }
}
