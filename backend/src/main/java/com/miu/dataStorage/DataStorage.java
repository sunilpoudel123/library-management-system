package com.miu.dataStorage;

import com.miu.person.User;
import com.miu.dao.UserDao;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class DataStorage implements Serializable {
    public static final String filePath = "resources/database/bin/";
    public static final String file = "database.ser";
    private static Map<Object, Object> data = new HashMap<>();

    public DataStorage() {
        this.data = read();
    }

    public static User testLogin(String username, String password) {
        return User.getAuthenticatedUser(username, password);
    }

    public static Map<Object, Object> read() {
        try (FileInputStream fileIn = new FileInputStream("resources/database/bin/database.ser");
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Object obj = in.readObject();

            if (obj instanceof Map) {
                data.putAll((Map<?, ?>) obj);
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

//    public static void write(Object object) {
//        try (FileOutputStream fileOut = new FileOutputStream(filePath + file, true);
//             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
//            out.writeObject(object);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void write(Object object) {
        boolean append = new File(filePath + file).exists();
        try (FileOutputStream fileOut = new FileOutputStream(filePath + file, append);
             ObjectOutputStream out = append ? new AppendableObjectOutputStream(fileOut) : new ObjectOutputStream(fileOut)) {
            out.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset();
        }
    }
}
