package com.miu.dataStorage;

import com.miu.User;
import com.miu.dao.UserDao;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class DataStorage implements Serializable {

    private static UserDao userDao = new UserDao();

    private static User user = new User();

    public static final String filePath = "resources/database/bin/database.ser";

    private static Map<Object, Object> data = new HashMap<>();

    public DataStorage() {
        this.data = load();
    }

    public static User testLogin(String username) {
        return user.findByUsername(username);
    }


    public static Map<Object, Object> load() {
        try (FileInputStream fileIn = new FileInputStream(filePath);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Object obj = in.readObject();
            if (obj instanceof Map) {
                data = (Map<Object, Object>) obj;
            } else {
                throw new ClassCastException("Expected data to be a Map, but found " + obj.getClass().getName());
            }
        } catch (FileNotFoundException e) {
            // File not found, return an empty map
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return data;
    }

    public static void save(Object object) {
        try (FileOutputStream fileOut = new FileOutputStream(filePath);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
