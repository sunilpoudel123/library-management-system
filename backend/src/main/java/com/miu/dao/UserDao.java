package com.miu.dao;

import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.User;
import com.miu.dataStorage.DataStorage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public final class UserDao<T extends Serializable> {

    private static Map<String, User> users = new HashMap<>();
    static {
        HashMap<Integer, User> loadedData = DataStorageFacade.readUserMap();

        if (loadedData != null) {
            for (Map.Entry<Integer, User> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof User) {
                    users.put(String.valueOf((Integer) entry.getKey()), (User) entry.getValue());
                }
            }
        }
    }

    public User login(String username, String password) {
        return null;
    }

    public static User findByUsername(String username) {
        User user = null;
        for (Map.Entry<String, User> entry : users.entrySet()) {
            if (entry.getValue().getUsername().equals(username)) {
                user = entry.getValue();
            }
        }
//        User user = users.get(username);
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
        Map<Object, Object> data = new HashMap<>();
        data.put(user.getUsername(), user);
        DataStorage.write(data);
        System.out.println("data write successfully");
        return null;
    }

    private static Map<Object, Object> readDatabase() {
        Map<Object, Object> objectMap = DataStorage.read();
        return objectMap;
    }

}
