package com.sherry.ProductMicroService;

import com.sherry.ProductMicroService.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class ProductMicroserviceApplication {

    /*public static void main(String[] args) {
        SpringApplication.run(ProductMicroserviceApplication.class, args);

        System.out.println("PRODUCT MICROSERVICE STARTED at 192.168.0.101:8081/products");


    }*/


    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }

}
