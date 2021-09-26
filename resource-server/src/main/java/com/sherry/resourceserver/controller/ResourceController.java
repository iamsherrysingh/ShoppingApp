package com.sherry.resourceserver.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class ResourceController {

    @Value("Hey there!")
    String hello;

    @Value("${server.port}")
    String port;

    @GetMapping("/hello")
    public String sayHello(){
        return hello;
    }

    @GetMapping("/port")
    public String port(){
        return port;
    }
}

