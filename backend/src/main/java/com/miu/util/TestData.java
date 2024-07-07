package com.miu.util;

import com.miu.Address;
import com.miu.book.Book;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.Author;
import com.miu.person.LibraryMember;
import com.miu.person.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestData {


    public static void main(String[] args) {
        TestData td = new TestData();
        td.libraryMemberData();
        td.userData();
        DataStorageFacade da = new DataStorageFacade();
        System.out.println(da.readUserMap());
    }

    public void userData() {
        DataStorageFacade.loadUserMap(allUsers);
    }

    //create library members
    public void libraryMemberData() {
        LibraryMember libraryMember = new LibraryMember(1001, "Andy", "Rogers", "641-223-2211", addresses.get(4));
        members.add(libraryMember);
        libraryMember = new LibraryMember(1002, "Drew", "Stevens", "702-998-2414", addresses.get(5));
        members.add(libraryMember);

        libraryMember = new LibraryMember(1003, "Sarah", "Eagleton", "451-234-8811", addresses.get(6));
        members.add(libraryMember);

        libraryMember = new LibraryMember(1004, "Ricardo", "Montalbahn", "641-472-2871", addresses.get(7));
        members.add(libraryMember);

        DataStorageFacade.loadMemberMap(members);
    }

    ///////////// DATA //////////////
    List<LibraryMember> members = new ArrayList<LibraryMember>();
    @SuppressWarnings("serial")

    List<Address> addresses = new ArrayList<Address>() {
        {
            add(new Address("101 S. Main", "Fairfield", "IA", "52556"));
            add(new Address("51 S. George", "Georgetown", "MI", "65434"));
            add(new Address("23 Headley Ave", "Seville", "Georgia", "41234"));
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
            add(new Author("Joe", "Thomas", "641-445-2123", "", "A happy man is he.", addresses.get(0)));
            add(new Author("Sandra", "Thomas", "641-445-2123", "", "A happy wife is she.", addresses.get(0)));
            add(new Author("Nirmal", "Pugh", "641-919-3223", "", "Thinker of thoughts.", addresses.get(0)));
            add(new Author("Andrew", "Cleveland", "976-445-2232", "", "Author of childrens' books.", addresses.get(0)));
            add(new Author("Sarah", "Connor", "123-422-2663", "", "Known for her clever style.", addresses.get(0)));
        }
    };

    @SuppressWarnings("serial")
    List<User> allUsers = new ArrayList<User>() {
        {
            add(new User("admin", "admin", "admin", "admin", null));
            add(new User("librarian", "librarian", "librarian", "librarian", null));
            add(new User("101", "xyz", "librarian", "librarian", null));
        }
    };
}