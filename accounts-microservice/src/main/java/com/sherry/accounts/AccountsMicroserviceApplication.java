package com.sherry.accounts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AccountsMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroserviceApplication.class, args);
	}
}
