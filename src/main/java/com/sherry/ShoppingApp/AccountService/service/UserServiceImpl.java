package com.sherry.ShoppingApp.AccountService.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    /**
     * checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return false if the userName and password combo is not correct
     */
    @Override
    public boolean checkUserNameAndPassword(String userName, String password) {
        //TO DO

        return true;
    }
}
