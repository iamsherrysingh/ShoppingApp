package com.sherry.FrontendMicroService.controller;

import com.sherry.FrontendMicroService.model.User;
import com.sherry.FrontendMicroService.service.MyUserDetailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    MyUserDetailManager myUserDetailManager;

    @GetMapping("/listallusers")
    public List<User> listAllUsers() {
        return myUserDetailManager.getUsers();
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) {
        myUserDetailManager.createUser(user);
    }


}
