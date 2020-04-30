package com.sherry.FrontendMicroService.controller;

import com.sherry.FrontendMicroService.model.User;
import com.sherry.FrontendMicroService.service.MyUserDetailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FrontendController {

    @Autowired
    MyUserDetailManager myUserDetailManager;

    @GetMapping(value = {"/", ""})
    public String sayHello() {
        return "Welcome to Spring Shopping Mall";
    }

    @PostMapping("/authenticate")
    public String getJwtToken(@RequestBody User user) {
        System.out.println(user);
        return "hj1b23hjb123bjk13.kjhjb13hj1b3b2hb12h3b12312hj3bh12b3j.b56b456b46jbk3k";
    }

    @GetMapping(value = {"/user"})
    public String helloUser() {
        return "Welcome User";
    }
}
