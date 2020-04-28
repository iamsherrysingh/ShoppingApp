package com.sherry.FrontendMicroService.service;

import com.sherry.FrontendMicroService.dao.AdminDAO;
import com.sherry.FrontendMicroService.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDAO adminDAO;

    @Override
    public Admin getAdminByAdminName(String adminName) {
        Optional<Admin> admin= adminDAO.findById(adminName);
        if(admin.isPresent()){
            return admin.get();
        }
        return null;
    }

    @Override
    public List<Admin> getAdmins() {
        return adminDAO.findAll();
    }

}
