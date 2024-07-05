package com.miu.dao;

import com.miu.User;
import com.miu.dataStorage.DataStorage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class UserDao<T extends Serializable> {

    private static Map<String, User> users = new HashMap<>();

    public UserDao() {
        Map<Object, Object> loadedData = readDatabase();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof User) {
                    users.put((String) entry.getKey(), (User) entry.getValue());
                }
            }
        }
    }


    public User login(String username, String password) {
        return null;
    }

    public static User findByUsername(String username) {
        User user = users.get(username);
        if (user != null) {
            return user;
        } else {
            System.out.println("User Not Found");
            return null;
        }
    }

    public static User findById(int id) {
        return null;
    }

    public static User save(User user) {
        return null;
    }

    private static Map<Object, Object> readDatabase() {
        DataStorage dataStorage = new DataStorage();
        Map<Object, Object> objectMap = dataStorage.load();
        return objectMap;
    }

}
