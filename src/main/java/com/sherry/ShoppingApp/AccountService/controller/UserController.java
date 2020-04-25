package com.sherry.ShoppingApp.AccountService.controller;

import com.sherry.ShoppingApp.AccountService.dao.UserDAO;
import com.sherry.ShoppingApp.AccountService.model.User;
import com.sherry.ShoppingApp.AccountService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDAO userDAO;

    @GetMapping("/list")
    public List<User> listUsers() {
        List<User> users= userDAO.findAll();
        users.forEach(System.out::println);
        return users;
    }
}
