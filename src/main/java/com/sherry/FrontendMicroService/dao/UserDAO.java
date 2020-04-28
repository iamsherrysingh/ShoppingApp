package com.sherry.FrontendMicroService.dao;

import com.sherry.FrontendMicroService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, String> {
}
