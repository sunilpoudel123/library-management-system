package com.miu.service;


import com.miu.dao.UserDaoImpl;
import com.miu.model.User;
import com.miu.util.HelperUtil;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDao;
    private User user;
    private HelperUtil helperUtil;

    public UserServiceImpl(UserDaoImpl userDao) {
        this.userDao = userDao;
    }


    @Override
    public User login() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        System.out.println("finding user by: " + username);
        User user = userDao.findByUsername(username);
        return user;
    }

}
