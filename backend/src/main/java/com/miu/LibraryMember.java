package com.miu;
import java.io.*;
import java.util.List;

import com.miu.dao.LibraryMemberDao;
import com.miu.libraryinterface.Member;

public class LibraryMember extends User  implements Member,Serializable  {
    private static final long serialVersionUID = 1L; // Optional, for version control
    private int memberId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<BookCopy> bookCopyList;
    private Address address;
    LibraryMemberDao libraryMemberDao=new LibraryMemberDao();
    public LibraryMember(int userId, String userName, String password, int memberId, String firstName, String lastName, String phoneNumber, Address address) {
        super(userId, userName, password);
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
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


    @Override
    public void viewCheckoutRecord() {
        System.out.println("Viewing record: " + memberId);
    }

    public boolean addLibraryMember(LibraryMember libraryMember) {
        return libraryMemberDao.addLibraryMember(libraryMember);
    }
}