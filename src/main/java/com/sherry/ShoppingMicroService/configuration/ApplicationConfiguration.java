package com.sherry.ShoppingMicroService.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sherry.ShoppingMicroService"})
@PropertySource({"classpath:ShoppingServiceApplication.properties"})
public class ApplicationConfiguration {
}
