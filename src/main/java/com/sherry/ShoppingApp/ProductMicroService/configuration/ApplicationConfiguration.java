package com.sherry.ShoppingApp.ProductMicroService.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sherry.ShoppingApp.ProductMicroService"})
@PropertySource({"classpath:ProductServiceApplication.properties"})
public class ApplicationConfiguration {

}
