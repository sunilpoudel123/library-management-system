package com.miu.dao;

import com.miu.model.User;
import com.miu.util.HelperUtil;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        Object object = readDatabase();
        List<User> user = (List<User>) object;
        for (User userObject : user) {
            if (userObject.getUsername().equals(username)) {
                return userObject;
            }
        }
        System.out.println("User Not Found");
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    private Object readDatabase() {
        Object object = HelperUtil.read();
        return object;
    }

}
