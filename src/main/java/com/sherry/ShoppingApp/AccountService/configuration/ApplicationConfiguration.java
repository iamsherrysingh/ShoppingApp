package com.sherry.ShoppingApp.AccountService.configuration;

import com.sherry.ShoppingApp.AccountService.service.UserService;
import com.sherry.ShoppingApp.AccountService.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.sherry.ShoppingApp.AccountService"})
@PropertySource({ "classpath:application.properties" })
public class ApplicationConfiguration {


}
