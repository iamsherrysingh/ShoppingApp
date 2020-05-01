package com.sherry.FrontendMicroService.controller;

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
        return "<h1>Welcome to Spring Shopping Mall</>";
    }

    @GetMapping(value = {"/user"})
    public String helloUser() {
        return "Welcome User";
    }
}
