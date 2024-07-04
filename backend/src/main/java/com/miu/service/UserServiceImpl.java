package com.miu.service;

import com.miu.dao.UserDao;
import com.miu.model.User;

public class UserServiceImpl implements UserService {

    private static UserDao userDao;

    @Override
    public User login() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        User user= userDao.findByUsername(username);

        return user;
    }


}
