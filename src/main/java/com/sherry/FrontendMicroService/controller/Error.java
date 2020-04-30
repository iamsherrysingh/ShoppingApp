package com.sherry.FrontendMicroService.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Error implements ErrorController {

    final String PATH = "/error";

    @RequestMapping(PATH)
    public String error() {
        return "<h1>Oops...you fucked up!</>";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
