package com.sherry.ShoppingApp.AccountsMicroService.controller;

import com.sherry.ShoppingApp.AccountsMicroService.model.User;
import com.sherry.ShoppingApp.AccountsMicroService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> listUsers() {
        return userService.listUsers();
    }

    /*
     * Usage: localhost:8080/accounts/user/Sherry
     */
    @GetMapping("/user/{userName}")
    public User getUserByUserName(@PathVariable String userName){
        return userService.getUserByUserName(userName);
    }

    /*
     * Usage: localhost:8080/accounts/check?userName=Sherry&password=password
     */
    @GetMapping("/check")
    public boolean checkUserNameAndPassword(@RequestParam("userName") String userName,@RequestParam("password") String password){
        return userService.checkUserNameAndPassword(userName, password);
    }
}
