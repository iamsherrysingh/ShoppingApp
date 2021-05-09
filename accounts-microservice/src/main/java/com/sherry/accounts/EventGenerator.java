package com.sherry.accounts;

import com.github.javafaker.Faker;
import com.sherry.accounts.model.Customer;

public class EventGenerator {
	public Faker faker = new Faker();

	public Customer generateRandomCustomer() {
		return Customer.builder().customerName("Raman").password("cropimage").build();
	}
}
