package com.sherry.FrontendMicroService.service;

import com.sherry.FrontendMicroService.model.Admin;

import java.util.List;

public interface AdminService {
    public Admin getAdminByAdminName(String adminName);
    public List<Admin> getAdmins();
}
