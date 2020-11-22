package com.sherry.accounts.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sherry.accounts.model.Customer;
import com.sherry.accounts.service.customerService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    customerService customerService;

    @GetMapping("/customers")
    public List<Customer> listCustomers() {
        return customerService.getCustomers();
    }

    /*
     * Usage: localhost:8080/accounts/user/Sherry
     */
    @GetMapping("/customer/{customerName}")
    public Customer getCustomerByCustomerName(@PathVariable String customerName) {
        return customerService.getCustomerByCustomerName(customerName);
    }

    /*
     * Usage: localhost:8080/accounts/check?userName=Sherry&password=password
     */
    @GetMapping("/check")
    public boolean checkCustomerNameAndPassword(@RequestParam("customerName") String customerName, @RequestParam("password") String password) {
        return customerService.checkCustomerNameAndPassword(customerName, password);
    }

    @PostMapping("/customer")
    public boolean addCustomer(@RequestBody Customer customer) {
    	
    	if(validatePassword(customer) 
    			&& getCustomerByCustomerName(customer.getCustomerName()).getCustomerName() == null) {
    		customerService.addCustomer(customer);
    		return true;
    	}
    	return false;
    }

    @DeleteMapping("/customer/{customerName}")
    public void deleteCustomer(@PathVariable String customerName) {
        customerService.deleteCustomer(customerName);
    }
    
    @PostMapping("/validatePassword")
    public boolean validatePassword(@RequestBody Customer customer) {
    	String patternString= "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$";
    	Pattern pattern= Pattern.compile(patternString);
    	Matcher matcher= pattern.matcher(customer.getPassword());

		if(customer.getPassword().length() < 8
				|| customer.getPassword().contains(customer.getCustomerName()) ) 
			return false;  
		if(matcher.matches() == false) //Provided password does not match the regex requirements
			return false;
		return true;
    }
}
