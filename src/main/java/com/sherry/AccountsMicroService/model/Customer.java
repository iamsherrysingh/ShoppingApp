package com.sherry.AccountsMicroService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

    @Id
    @Column(name="customer_name")
    private  String customerName;

    @Column(name="password")
    private  String password;

    public Customer(){}

    public Customer(String customerName, String password) {
        this.customerName = customerName;
        this.password = password;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String userName) {
        this.customerName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
