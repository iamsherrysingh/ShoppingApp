package com.sherry.AccountsMicroService.dao;

import com.sherry.AccountsMicroService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, String> {

}
