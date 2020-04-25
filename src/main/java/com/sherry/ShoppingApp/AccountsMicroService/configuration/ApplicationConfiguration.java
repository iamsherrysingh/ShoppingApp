package com.sherry.ShoppingApp.AccountsMicroService.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sherry.ShoppingApp.AccountsMicroService"})
@PropertySource({"classpath:AccountsServiceApplication.properties"})
public class ApplicationConfiguration {


}
