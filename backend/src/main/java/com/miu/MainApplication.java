package com.miu;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.book.BookFactory;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.PopulateDataUtil;
import com.miu.factory.CheckoutFactory;
import com.miu.factory.MemberFactory;
import com.miu.person.Author;
import com.miu.person.LibraryMember;
import com.miu.person.User;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) throws ParseException {
      /*  Address add1 = new Address("Street1", "Fairfield", "Iowa", "52555");
        LibraryMember member = MemberFactory.addLibrarianMember("Trump", "Donald", "aung", add1);
        LibraryMember.addLibraryMember(member);
        System.out.println("Checking name: " + member.getFirstName());
        System.out.println("finding member by id: 1 " + LibraryMember.findMember(1).getFirstName());
  *



        //LibraryMember member2 = LibraryMember.findMember(member.getMemberId());
        //System.out.println("Checking name after find Member: " + member2.getFirstName());
        /*
        BookCopy bookCopy = new BookCopy();
        Author author = new Author("", "", "", "", "", null);
        Book book = (Book) BookFactory.createBook("MPP", "16855", 7, author, bookCopy);

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
        } */

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = dateFormat.parse("2024-07-01");
        System.out.println("currentDate"+currentDate );
       CheckoutRecordEntry checkEntry = CheckoutFactory.addNewCheckoutRecordEntry( 1, "123", "1",currentDate,currentDate,currentDate);
       CheckoutRecordEntry.addCheckoutRecordEntry(checkEntry);
    }
}
