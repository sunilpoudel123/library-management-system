package com.miu;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.book.BookFactory;
import com.miu.checkout.CheckoutFactory;
import com.miu.checkout.CheckoutRecord;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.PopulateDataUtil;
import com.miu.person.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
       /* Address add1 = new Address("Street1", "Fairfield", "Iowa", "52555");
        Member member = MemberFactory.addLibraryMember("Trump", "Donald", "aung", add1);
       */
           // public CheckoutRecordEntry(int memberId, String isbn, String bookCopyId, Date checkoutDate, Date dueDate,Date paidDate)
        Date currentDate = new Date();
        CheckoutRecordEntry checkouot= CheckoutFactory.addNewCheckoutRecordEntry(8,"ISBN008","CPY001",currentDate,currentDate,currentDate);
        CheckoutRecordEntry.addCheckoutRecordEntry(checkouot);

        System.out.println("Member ID testing ... " +checkouot.getMemberId());

        CheckoutRecordEntry checkouot1=CheckoutRecordEntry.findCheckoutEntry(8);

        System.out.println("Member ID testing after inserting ..." +checkouot1.getMemberId());

        CheckoutRecordEntry recordEntry=  CheckoutRecordEntry.findCheckoutEntry(checkouot.getMemberId());

        List<CheckoutRecordEntry> list=new ArrayList<>();
        list = CheckoutRecord.checkoutRecordEntryList();

        for(CheckoutRecordEntry checkoutRecordEntry:list){
            System.out.println("Test checkout List ***" +checkoutRecordEntry.getMemberId());
        }

        /*

      //  System.out.println(recordEntry.getMemberId() + "" + recordEntry.getIsbn());

        LibraryMember.addLibraryMember((LibraryMember) member);
        System.out.println("Checking name: " + ((LibraryMember)member).getFirstName());
      //  System.out.println("finding member by id: 1 " + LibraryMember.findMember(1).getFirstName());

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
    }
}
