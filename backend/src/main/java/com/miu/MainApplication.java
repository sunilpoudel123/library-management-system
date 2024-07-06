package com.miu;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.book.PublicationFactory;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.PopulateDataUtil;
import com.miu.person.Author;
import com.miu.person.User;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {

        BookCopy bookCopy = new BookCopy();
        Author author = new Author("","", "", "","", null);
        Book book = (Book) PublicationFactory.createBook("MPP", "16855", 7, author, bookCopy);

        System.out.println(bookCopy.getBook().getISBN());

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
