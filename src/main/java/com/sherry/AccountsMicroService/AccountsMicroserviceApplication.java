package com.sherry.AccountsMicroService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsMicroserviceApplication.class, args);

		System.out.println("ACCOUNTS MICROSERVICE STARTED at 192.168.0.101:8080/accounts");


	}

}
