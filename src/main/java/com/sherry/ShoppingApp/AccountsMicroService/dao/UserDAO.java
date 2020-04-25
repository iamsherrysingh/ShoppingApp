package com.sherry.ShoppingApp.AccountsMicroService.dao;

import com.sherry.ShoppingApp.AccountsMicroService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

}
