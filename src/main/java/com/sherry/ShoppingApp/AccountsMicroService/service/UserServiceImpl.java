package com.sherry.ShoppingApp.AccountsMicroService.service;

import com.sherry.ShoppingApp.AccountsMicroService.dao.UserDAO;
import com.sherry.ShoppingApp.AccountsMicroService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    /**
     *checks if the userName and password combo is correct
     *
     * @param userName user name as String
     * @param password password as String
     * @return true if the userName and password combo is correct
     * @return false if the userName and password combo is not correct
     */
    @Override
    public boolean checkUserNameAndPassword(String userName, String password) {
        User user= getUserByUserName(userName);
        if(user.getUserName() != null) {
            if(userName.equals(user.getUserName()) && password.equals(user.getPassword()))
                return true;
            else
                return false;
        }
        return false;
    }

    @Override
    public List<User> getUsers() {
        List<User> users= userDAO.findAll();
        users.forEach(System.out::println);
        return users;
    }

    @Override
    public User getUserByUserName(String userName) {
        Optional<User> user= userDAO.findById(userName);
        if(user.isPresent()){
            return user.get();
        }else {
            return new User();
        }
    }
}
