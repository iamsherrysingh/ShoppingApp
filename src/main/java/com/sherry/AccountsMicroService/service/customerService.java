package com.sherry.AccountsMicroService.service;

import com.sherry.AccountsMicroService.model.Customer;

import java.util.List;

public interface customerService {
    /**
     *checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return true if the userName and password combo is correct
     * @return false if the userName and password combo is not correct
     */
    boolean checkCustomerNameAndPassword(String userName, String password);

    public List<Customer> getCustomers();

    public Customer getCustomerByCustomerName(String userName);

    public void addCustomer(Customer customer);

    public void deleteCustomer(String userName);

}
