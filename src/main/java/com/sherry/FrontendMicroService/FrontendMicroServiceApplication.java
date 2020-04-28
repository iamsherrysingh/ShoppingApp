package com.sherry.FrontendMicroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
public class FrontendMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroServiceApplication.class, args);

        System.out.println("FRONTEND MICROSERVICE STARTED at 192.168.0.101:8082/frontend");
    }
}
