package com.sherry.AccountsMicroService.controller;

import com.sherry.AccountsMicroService.model.User;
import com.sherry.AccountsMicroService.service.UserService;
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
        return userService.getUsers();
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

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @DeleteMapping("/user/{userName}")
    public void deleteUser(@PathVariable String userName){
        userService.deleteUser(userName);
    }
}
