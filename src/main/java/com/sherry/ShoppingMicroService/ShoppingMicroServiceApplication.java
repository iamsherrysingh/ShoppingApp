package com.sherry.ShoppingMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShoppingMicroServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShoppingMicroServiceApplication.class, args);

        System.out.println("SHOPPING MICROSERVICE STARTED");
    }
}
