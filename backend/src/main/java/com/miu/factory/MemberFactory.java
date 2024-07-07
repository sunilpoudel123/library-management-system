package com.miu.factory;

import com.miu.Address;
import com.miu.person.LibraryMember;

public class MemberFactory {
    public static LibraryMember addLibrarianMember(String firstName, String lastName, String phoneNumber, Address address) {
        return new LibraryMember(firstName, lastName, phoneNumber, address);
    }
}
