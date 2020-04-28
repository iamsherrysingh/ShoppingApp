package com.sherry.FrontendMicroService.controller;

import com.sherry.FrontendMicroService.model.Admin;
import com.sherry.FrontendMicroService.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frontend")
public class FrontendController {

    @Autowired
    AdminService adminService;

    @GetMapping(value = {"/" , ""})
    public String sayHello(){
        return "Welcome to Spring Shopping Mall";
    }

    @GetMapping("/admins")
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }

    @PostMapping("/authenticate")
    public String getJwtToken(@RequestBody Admin admin){
        System.out.println(admin);
        return "hj1b23hjb123bjk13.kjhjb13hj1b3b2hb12h3b12312hj3bh12b3j.b56b456b46jbk3k";
    }

}
