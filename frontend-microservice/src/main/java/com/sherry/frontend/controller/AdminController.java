package com.sherry.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sherry.frontend.model.User;
import com.sherry.frontend.service.MyUserDetailManager;

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
