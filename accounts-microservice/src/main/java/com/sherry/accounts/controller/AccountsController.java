package com.sherry.accounts.controller;

import java.util.List;
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
import com.sherry.accounts.service.CustomerService;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    CustomerService customerService;

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
    	return customerService.addCustomer(customer);

    }

    @DeleteMapping("/customer/{customerName}")
    public boolean deleteCustomer(@PathVariable String customerName) {
        return customerService.deleteCustomer(customerName);
    }
    
    @PostMapping("/validatePassword")
    public boolean validatePassword(@RequestBody Customer customer) {
    	return customerService.validatePassword(customer);
    }
}
