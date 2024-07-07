package com.miu.person;

import com.miu.Address;
import com.miu.book.BookCopy;

import java.io.*;
import java.util.List;

import com.miu.dao.LibraryMemberDao;
import com.miu.util.HelperUtil;

public class LibraryMember extends UserRole implements Member, Serializable {
    private static final long serialVersionUID = 1L; // Optional, for version control
    private int memberId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<BookCopy> bookCopyList;
    private Address address;

    public LibraryMember(String firstName, String lastName, String phoneNumber, Address address) {
        this.memberId = HelperUtil.generateID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public List<BookCopy> getBookCopyList() {
        return bookCopyList;
    }

    public Address getAddress() {
        return address;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBookCopyList(List<BookCopy> bookCopyList) {
        this.bookCopyList = bookCopyList;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public static LibraryMember addLibraryMember(LibraryMember libraryMember) {
        return LibraryMemberDao.addLibraryMember(libraryMember);
    }

    public static LibraryMember findMember(int memberId) {
        return LibraryMemberDao.findMember(memberId);
    }

    public static LibraryMember editMember(LibraryMember member) {
          return LibraryMemberDao.editMember(member);
    }
}