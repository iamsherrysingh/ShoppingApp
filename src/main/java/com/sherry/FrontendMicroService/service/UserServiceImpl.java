package com.sherry.FrontendMicroService.service;

import com.sherry.FrontendMicroService.dao.UserDAO;
import com.sherry.FrontendMicroService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUserByUserName(String userName) {
        Optional<User> user= userDAO.findById(userName);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return userDAO.findAll();
    }

}
