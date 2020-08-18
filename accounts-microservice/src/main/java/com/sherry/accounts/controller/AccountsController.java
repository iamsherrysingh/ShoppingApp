package com.sherry.accounts.controller;

import com.sherry.accounts.model.Customer;
import com.sherry.accounts.service.customerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void addCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
    }

    @DeleteMapping("/customer/{customerName}")
    public void deleteCustomer(@PathVariable String customerName) {
        customerService.deleteCustomer(customerName);
    }
}
