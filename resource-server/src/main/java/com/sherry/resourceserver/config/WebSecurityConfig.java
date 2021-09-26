package com.sherry.resourceserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Authenticates all traffic
//        http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();

        //Permits all traffic without authentication
//        http.authorizeRequests().anyRequest().permitAll();
//        http.cors().and().csrf().disable();
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
    }



}