package com.miu;

import com.miu.util.PopulateDataUtil;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        System.out.println("Library Management System Running .... ");
        System.out.println("#### Default Users are adding #####");
        PopulateDataUtil.addUsers();
        System.out.println("### Please login your username for testing: ###");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = scanner.nextLine();



    }
}
