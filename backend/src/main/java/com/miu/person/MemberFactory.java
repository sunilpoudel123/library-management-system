package com.miu.person;

import com.miu.Address;

public class MemberFactory {
    public static Member addLibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
        return new LibraryMember(firstName, lastName, phoneNumber, address);
    }
    public static Member addLibrarian(String firstName, String lastName, String phoneNumber, Address address) {
        return new LibraryMember(firstName, lastName, phoneNumber, address);
    }
    public static Member addAdmin(String firstName, String lastName, String phoneNumber, Address address) {
        return new LibraryMember(firstName, lastName, phoneNumber, address);
    }
}
