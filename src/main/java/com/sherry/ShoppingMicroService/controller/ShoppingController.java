package com.sherry.ShoppingMicroService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping")
public class ShoppingController {

    @GetMapping(value = {"/" , ""})
    public String sayHello(){
        return "Welcome to Spring Shopping Mall";
    }

}
