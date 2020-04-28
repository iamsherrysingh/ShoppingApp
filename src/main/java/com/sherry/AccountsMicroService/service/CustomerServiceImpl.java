package com.sherry.AccountsMicroService.service;

import com.sherry.AccountsMicroService.dao.CustomerDAO;
import com.sherry.AccountsMicroService.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements customerService {

    @Autowired
    CustomerDAO customerDAO;

    /**
     *checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return true if the userName and password combo is correct
     * @return false if the userName and password combo is not correct
     */
    @Override
    public boolean checkCustomerNameAndPassword(String customerName, String password) {
        Customer customer = getCustomerByCustomerName(customerName);
        if(customer.getCustomerName() != null) {
            if(customerName.equals(customer.getCustomerName()) && password.equals(customer.getPassword()))
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = customerDAO.findAll();
        customers.forEach(System.out::println);
        return customers;
    }

    @Override
    public Customer getCustomerByCustomerName(String customerName) {
        Optional<Customer> customer= customerDAO.findById(customerName);
        if(customer.isPresent()){
            return customer.get();
        }else {
            return new Customer();
        }
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.save(customer);
    }

    @Override
    public void deleteCustomer(String customerName) {
        customerDAO.delete(getCustomerByCustomerName(customerName));
    }
}
