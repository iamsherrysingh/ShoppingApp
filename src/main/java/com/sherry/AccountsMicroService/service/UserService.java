package com.sherry.AccountsMicroService.service;

import com.sherry.AccountsMicroService.model.User;

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

    public List<User> getUsers();

    public User getUserByUserName(String userName);

    public void addUser(User user);

    public void deleteUser(String userName);

}
