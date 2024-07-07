package com.miu;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.book.BookFactory;
import com.miu.dao.BookDao;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.dataStorage.PopulateDataUtil;
import com.miu.person.*;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
     //   Address add1 = new Address("Street1", "Fairfield", "Iowa", "52555");
      //  Member member = MemberFactory.addLibraryMember("Trump", "Donald", "aung", add1);

      //  LibraryMember.addLibraryMember((LibraryMember) member);
     //   System.out.println("Checking name: " + ((LibraryMember) member).getFirstName());
//        System.out.println("finding member by id: 1 " + LibraryMember.findMember(1).getFirstName());
        Author author = new Author("TEST1", "Test1", "8998822", "", "ShortBio", null);
      //  Book book=new Book("","","","","");
      //  Book.addBook()

      //  Author author = new Author("", "", "", "", "", null);
     //   Book book = (Book) BookFactory.createBook("MPP", "16855", 7, author, bookCopy);


        System.out.println(BookDao.getAllBooks());

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
