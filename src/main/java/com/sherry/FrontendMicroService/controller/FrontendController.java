package com.sherry.FrontendMicroService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frontend")
public class FrontendController {

    @GetMapping(value = {"/" , ""})
    public String sayHello(){
        return "Welcome to Spring Shopping Mall";
    }

}
