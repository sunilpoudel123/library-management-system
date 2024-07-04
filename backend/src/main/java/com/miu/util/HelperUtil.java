package com.miu.util;

import java.io.*;

public class HelperUtil {


    public static final String DATABASE_PATH = "resources/database/bin/database.ser";

    public static void save(Object data) {
        try (FileOutputStream fileOut = new FileOutputStream(DATABASE_PATH);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object read() {
        try (FileInputStream fileIn = new FileInputStream(DATABASE_PATH);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            System.out.println("Deserialized data:");
            return in.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return null;
    }

    public static void update(String data) {

    }

}
