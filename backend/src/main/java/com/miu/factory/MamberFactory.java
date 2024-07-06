package com.miu.factory;

import com.miu.Address;
import com.miu.LibraryMember;
import com.miu.User;
import com.miu.Admin;
import com.miu.Librarian;

public class MamberFactory {
    public static boolean addLibrarianMember(int userId, String userName, String password, int memberId, String firstName, String lastName, String phoneNumber, String street, String city, String state, String zip) {
        Address address = new Address(street, city, state, zip);
        LibraryMember libraryMember= new LibraryMember( userId,  userName,  password,  memberId,  firstName,  lastName,  phoneNumber,  address);
        if(libraryMember.getUserName() != null){
            return true;
        }
        return false;
    }
    /*
    public static User addLibrarian() {
        return new Librarian();
    }

    public static User addAdmin() {
        return new Admin();
    } */
}
