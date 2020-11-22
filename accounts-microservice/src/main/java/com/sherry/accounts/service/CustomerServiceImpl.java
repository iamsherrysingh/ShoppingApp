package com.sherry.accounts.service;

import com.sherry.accounts.dao.CustomerDAO;
import com.sherry.accounts.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerServiceImpl implements customerService {

    @Autowired
    CustomerDAO customerDAO;

    /**
     * checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return false if the userName and password combo is not correct
     */
    @Override
    public boolean checkCustomerNameAndPassword(String customerName, String password) {
        Customer customer = getCustomerByCustomerName(customerName);
        if (customer.getCustomerName() != null) {
            if (customerName.equals(customer.getCustomerName()) && password.equals(customer.getPassword()))
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
        Optional<Customer> customer = customerDAO.findById(customerName);
        if (customer.isPresent()) {
            return customer.get();
        } else {
            return new Customer();
        }
    }

    @Override
    public boolean addCustomer(Customer customer) {
    	if(validatePassword(customer) 
    			&& getCustomerByCustomerName(customer.getCustomerName())
    					.getCustomerName() == null) {
    		customerDAO.save(customer);
    		return true;
    	}
    
    	return false;
    }

    @Override
    public boolean deleteCustomer(String customerName) {
    	if(getCustomerByCustomerName(customerName)
    					.getCustomerName() != null) {
    		customerDAO.delete(getCustomerByCustomerName(customerName));
    		return true;
    	}
    	return false;
    }

	@Override
	public boolean validatePassword(Customer customer) {
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