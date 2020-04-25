package com.sherry.ShoppingApp.AccountService.service;

import com.sherry.ShoppingApp.AccountService.dao.UserDAO;
import com.sherry.ShoppingApp.AccountService.model.User;
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
    public List<User> listUsers() {
        List<User> users= userDAO.findAll();
        users.forEach(System.out::println);
        return users;
    }

    @Override
    public User getUserByUserName(String userName) {
        Optional<User> user= userDAO.findById(userName);
        if(user.isPresent()){
            System.out.println(user.get());
            return user.get();
        }
        System.out.println("NO USER FOUND with name "+ userName);
        return new User();
    }
}
