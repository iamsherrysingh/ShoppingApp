package com.sherry.ShoppingApp.AccountsMicroService.service;

import com.sherry.ShoppingApp.AccountsMicroService.model.User;

import java.util.List;

public interface UserService {
    /**
     *checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return true if the userName and password combo is correct
     * @return false if the userName and password combo is not correct
     */
    boolean checkUserNameAndPassword(String userName, String password);

    public List<User> listUsers();

    public User getUserByUserName(String userName);

}
