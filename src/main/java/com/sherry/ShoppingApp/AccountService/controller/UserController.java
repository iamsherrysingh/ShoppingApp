package com.sherry.ShoppingApp.AccountService.controller;

import com.sherry.ShoppingApp.AccountService.dao.UserDAO;
import com.sherry.ShoppingApp.AccountService.model.User;
import com.sherry.ShoppingApp.AccountService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserDAO userDAO;

    @GetMapping("/users")
    public List<User> listUsers() {
        List<User> users= userDAO.findAll();
        users.forEach(System.out::println);
        return users;
    }

    @GetMapping("/user/{userName}")
    public User findById(@PathVariable String userName){
        Optional<User> user= userDAO.findById(userName);
        if(user.isPresent()){
            System.out.println(user.get());
            return user.get();
        }
        System.out.println("NO USER FOUND with name "+ userName);
        return new User();
    }

}
