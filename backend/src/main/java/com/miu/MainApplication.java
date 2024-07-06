package com.miu;
import com.miu.factory.*;
import com.miu.factoryinterface.*;

public class MainApplication {

    public static void main(String[] args) {
   /*     System.out.println("Library Management System Running .... ");
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
        } */

      //  Address add1 = new Address("Street1", "Fairfield", "Iowa", "52555");
     //   LibraryMember libraryMember = new LibraryMember(1, "toetoe1", "aung", "6412332028", add1, "member");

        LibraryMemberInterface factory = new LibraryMemberFactory();
        factory.addMember("keang", "hua", "6412332028", "member","Street1", "Fairfield", "Iowa", "52555");
        LibraryMember m=factory.findMember(39);

        if(m == null){
            System.out.printf("not found");
        } else {
            System.out.println(m.getFirstName() +m.getLastName());
        }
    }
}
