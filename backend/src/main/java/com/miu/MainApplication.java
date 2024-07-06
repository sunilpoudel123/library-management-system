package com.miu;

import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.PopulateDataUtil;
import com.miu.person.User;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Library Management System Running .... ");
        System.out.println("#### Default Users are adding #####");
        PopulateDataUtil.addUsers();
        System.out.println("## Users are add successful ##");
        System.out.println("### Please login your username for testing: ###");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password for testing:");
        String password = scanner.nextLine();
        User user = DataStorage.testLogin(username, password);
        if (user == null) {
            System.out.println("Invalid username or password");
        } else {
            System.out.println("Login Successful for : " + user);
        }
    }
}
