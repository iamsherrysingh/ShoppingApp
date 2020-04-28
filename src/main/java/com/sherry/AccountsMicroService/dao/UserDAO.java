package com.sherry.AccountsMicroService.dao;

import com.sherry.AccountsMicroService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {

}