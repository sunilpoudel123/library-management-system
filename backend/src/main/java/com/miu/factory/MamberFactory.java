package com.miu.factory;

import com.miu.Address;
import com.miu.LibraryMember;
import com.miu.User;
import com.miu.Admin;
import com.miu.Librarian;

public class MamberFactory {
    public static LibraryMember addLibrarianMember(int memberId, String firstName, String lastName, String phoneNumber, Address address ) {
        return new LibraryMember( memberId,  firstName,  lastName,  phoneNumber, address);
       }
}
