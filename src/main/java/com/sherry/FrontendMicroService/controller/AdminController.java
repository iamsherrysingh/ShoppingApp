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
    MyUserDetailManager userService;

    @GetMapping("/listallusers")
    public List<User> listAllUsers() {
        return userService.getUsers();
    }

    @PostMapping("/adduser")
    public void addUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/authenticate")
    public String getJwtToken() {
        return "hj1b23hjb123bjk13.kjhjb13hj1b3b2hb12h3b12312hj3bh12b3j.b56b456b46jbk3k";
    }
}
