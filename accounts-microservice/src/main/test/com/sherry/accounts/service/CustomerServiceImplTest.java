package com.sherry.accounts.service;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sherry.accounts.model.Customer;

public class CustomerServiceImplTest {
	static CustomerService customerService;
	static Customer customer;
	
	@BeforeClass
	public static void beforeClass() {
		customerService= new CustomerServiceImpl();
		customer= new Customer("CustomerName", "");
	}

	@AfterClass
	public static void afterClass() {
		customerService= null;
		customer= null;
	}
	
	@Test
	public void testCheckCustomerNameAndPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomers() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCustomerByCustomerName() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidatePassword() {
		customer.setPassword("Password");
		assertEquals(customerService.validatePassword(customer), false);
		
		customer.setPassword("Password1");
		assertEquals(customerService.validatePassword(customer), true);
		
		customer.setPassword("SUPER S3RCR3T PASSWORD YO!!");
		assertEquals(customerService.validatePassword(customer), false);
		
		customer.setPassword("2password13");
		assertEquals(customerService.validatePassword(customer), false);
		
		customer.setPassword("Pass   cusTomerNaMe  123");
		assertEquals(customerService.validatePassword(customer), false);
	}

}
