package com.sherry.ShoppingApp.AccountService.dao;

import com.sherry.ShoppingApp.AccountService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

}
