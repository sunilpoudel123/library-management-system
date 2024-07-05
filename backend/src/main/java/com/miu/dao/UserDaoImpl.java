package com.miu.dao;

import com.miu.model.User;
import com.miu.util.HelperUtil;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class UserDaoImpl<T extends Serializable> implements UserDao {

    private Map<String, User> users = new HashMap<>();

    public UserDaoImpl() {
        Map<Object, Object> loadedData = readDatabase();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof User) {
                    users.put((String) entry.getKey(), (User) entry.getValue());
                }
            }
        }
    }


    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        User user = users.get(username);
        if (user != null) {
            return user;
        } else {
            System.out.println("User Not Found");
            return null;
        }
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    private Map<Object, Object> readDatabase() {
        HelperUtil helperUtil = new HelperUtil();
        Map<Object, Object> objectMap = helperUtil.load();
        return objectMap;
    }

}
