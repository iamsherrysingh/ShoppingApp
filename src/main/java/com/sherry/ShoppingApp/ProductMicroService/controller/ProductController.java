package com.sherry.ShoppingApp.ProductMicroService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from ProductController";
    }

}
