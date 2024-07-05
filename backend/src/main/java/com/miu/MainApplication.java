package com.miu;

import com.miu.model.User;
import com.miu.util.HelperUtil;
import com.miu.util.PopulateDataUtil;

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

        User user = HelperUtil.testLogin(username);
        if (user == null) {
            System.out.println("Invalid username or password");
        } else {
            System.out.println("Login Successful for : " + user);
        }
    }
}
