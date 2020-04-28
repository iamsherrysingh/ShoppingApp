package com.sherry.FrontendMicroService.service;

import com.sherry.FrontendMicroService.model.User;

import java.util.List;

public interface UserService {
    public User getUserByUserName(String userName);
    public List<User> getUsers();
}
