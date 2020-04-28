package com.sherry.FrontendMicroService.controller;

import com.sherry.FrontendMicroService.model.User;
import com.sherry.FrontendMicroService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frontend")
public class FrontendController {

    @Autowired
    UserService userService;

    @GetMapping(value = {"/" , ""})
    public String sayHello(){
        return "Welcome to Spring Shopping Mall";
    }

    @GetMapping("/admins")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping("/authenticate")
    public String getJwtToken(@RequestBody User user){
        System.out.println(user);
        return "hj1b23hjb123bjk13.kjhjb13hj1b3b2hb12h3b12312hj3bh12b3j.b56b456b46jbk3k";
    }

    @GetMapping(value = {"/admin"})
    public String helloAdmin(){
        return "Welcome Admin";
    }

    @GetMapping(value = {"/user"})
    public String helloUser(){
        return "Welcome User";
    }


}
