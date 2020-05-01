package com.sherry.FrontendMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FrontendMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FrontendMicroServiceApplication.class, args);

        System.out.println("\nFRONTEND MICROSERVICE STARTED at 192.168.0.101:8082/");
    }
}
