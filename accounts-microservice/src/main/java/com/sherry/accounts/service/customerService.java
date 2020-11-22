package com.sherry.accounts.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.sherry.accounts.model.Customer;

public interface customerService {
    /**
     * checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return false if the userName and password combo is not correct
     */
    boolean checkCustomerNameAndPassword(String userName, String password);

    public List<Customer> getCustomers();

    public Customer getCustomerByCustomerName(String userName);

    public boolean addCustomer(Customer customer);

    public boolean deleteCustomer(String userName);
    
    public boolean validatePassword(@RequestBody Customer customer);

}
