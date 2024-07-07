package com.miu.util;

import com.miu.Address;
import com.miu.book.Book;
import com.miu.checkout.CheckoutRecord;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.*;
import com.miu.book.BookCopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Date;
import java.util.Date;
import java.util.List;

public class TestData {


    public static void main(String[] args) {
        TestData td = new TestData();
        td.libraryMemberData();
        td.userData();
        td.allBooks();
        td.checkoutRecordData();
        td.checkoutEntryData();
        DataStorageFacade da = new DataStorageFacade();
        System.out.println(da.readUserMap());
    }

    public void userData() {
        DataStorageFacade.loadUserMap(allUsers);
    }

    //create library members
    public void libraryMemberData() {
        Member libraryMember = new LibraryMember("Hang Kheang", "Taing", "6412230129", addresses.get(4));
        members.add(libraryMember);
        libraryMember = new LibraryMember("Tegshbayar", "Ganbat", "7029982414", addresses.get(5));
        members.add(libraryMember);

        libraryMember = new LibraryMember("Teo Teo", "Aung", "4512348811", addresses.get(6));
        members.add(libraryMember);

        libraryMember = new LibraryMember("Sunil", "Poudel", "6414722871", addresses.get(7));
        members.add(libraryMember);

        DataStorageFacade.loadMemberMap(members);
    }

    List<CheckoutRecordEntry> entriesList = new ArrayList<CheckoutRecordEntry>();

    public void checkoutEntryData() {
        Date currentdate = new Date();
        CheckoutRecordEntry entryrecord = new CheckoutRecordEntry(1, "ISBN3", "CPY0003", currentdate, currentdate, currentdate);
        entriesList.add(entryrecord);

        CheckoutRecordEntry entryrecord1 = new CheckoutRecordEntry(2, "ISBN4", "CPY0004", currentdate, currentdate, currentdate);
        entriesList.add(entryrecord);

        CheckoutRecordEntry entryrecord2 = new CheckoutRecordEntry(3, "ISBN5", "CPY0004", currentdate, currentdate, currentdate);
        entriesList.add(entryrecord);


        DataStorageFacade.loadMemberMap(members);
    }

    //create library members
    public void checkoutRecordData() {
        CheckoutRecord libraryMember = new CheckoutRecord();

        DataStorageFacade.saveNewCheckoutEntry(new CheckoutRecordEntry(12, "2323", "23", new Date(), new Date(), new Date()));

    }

    //create library members
    public void allBooks() {
        DataStorageFacade.loadBookMap(allBooks);
    }

    ///////////// DATA //////////////
    List<Member> members = new ArrayList<Member>();
    @SuppressWarnings("serial")

    List<Address> addresses = new ArrayList<Address>() {
        {
            add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
            add(new Address("51 S. George", "Georgetown", "MI", "65434"));
            add(new Address("23 Headley Ave", "Seville", "LA", "41234"));
            add(new Address("1 N. Baton", "Baton Rouge", "LA", "33556"));
            add(new Address("5001 Venice Dr.", "Los Angeles", "CA", "93736"));
            add(new Address("1435 Channing Ave", "Palo Alto", "CA", "94301"));
            add(new Address("42 Dogwood Dr.", "Fairfield", "IA", "52556"));
            add(new Address("501 Central", "Mountain View", "CA", "94707"));
        }
    };
    @SuppressWarnings("serial")
    public List<Author> allAuthors = new ArrayList<Author>() {
        {
            add(new Author("Joe", "Thomas", "6414452123", "", "A happy man is he.", addresses.getFirst()));
            add(new Author("Sandra", "Thomas", "6414452123", "", "A happy wife is she.", addresses.getFirst()));
            add(new Author("Nirmal", "Pugh", "6419193223", "", "Thinker of thoughts.", addresses.getFirst()));
            add(new Author("Andrew", "Cleveland", "9764452232", "", "Author of children' books.", addresses.getFirst()));
            add(new Author("Sarah", "Connor", "1234222663", "", "Known for her clever style.", addresses.getFirst()));
        }
    };

    @SuppressWarnings("serial")
    List<User> allUsers = new ArrayList<User>() {
        {
            add(new User("admin", "admin", "admin", "admin", new Admin()));
            add(new User("librarian", "librarian", "librarian", "librarian", new Librarian()));
            add(new User("superadmin", "superadmin", "superadmin", "superadmin", Arrays.asList(new Admin(), new Librarian())));
        }
    };

    BookCopy bookCopy = new BookCopy("title", "isbn");

    List<Book> allBooks = new ArrayList<Book>() {
        {
            add(new BookCopy("admin", "admin", 1, allAuthors.get(0), bookCopy));
        }
    };

    @SuppressWarnings("serial")
    List<CheckoutRecord> allCheckoutRecord = new ArrayList<CheckoutRecord>() {
        {
            add(new CheckoutRecord());
        }
    };
}