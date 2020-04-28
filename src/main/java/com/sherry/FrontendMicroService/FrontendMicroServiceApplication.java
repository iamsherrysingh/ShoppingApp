package com.sherry.FrontendMicroService;

import com.sherry.FrontendMicroService.dao.UserDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserDAO.class)
public class FrontendMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroServiceApplication.class, args);

        System.out.println("FRONTEND MICROSERVICE STARTED at 192.168.0.101:8082/frontend");
    }
}
