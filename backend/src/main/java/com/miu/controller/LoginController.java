package com.miu.controller;


import com.miu.dao.UserDaoImpl;
import com.miu.model.User;
import com.miu.service.UserService;
import com.miu.service.UserServiceImpl;

public class LoginController {

    private static UserDaoImpl userDao = new UserDaoImpl();

    private static UserService userService = new UserServiceImpl(userDao);

    public User login(String username, String password) {
        System.out.println("login requested by: " + username);

        User user = userService.findByUsername(username);
        if (user == null) {
            System.out.println("user is not found");
        }
        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            System.out.println("login successful");
        }

        return user;
    }

    public void logOut() {
        System.out.println("logout requested");
    }

}
