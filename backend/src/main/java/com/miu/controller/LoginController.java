package com.miu.controller;


import com.miu.model.User;
import com.miu.service.UserService;
import com.miu.service.UserServiceImpl;

public class LoginController {

    private static final UserService userService = new UserServiceImpl();

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

    public void logOut(){
        System.out.println("logout requested");
    }

}
