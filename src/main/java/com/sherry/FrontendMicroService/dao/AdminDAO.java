package com.sherry.FrontendMicroService.dao;

import com.sherry.FrontendMicroService.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDAO extends JpaRepository<Admin, String> {
}
