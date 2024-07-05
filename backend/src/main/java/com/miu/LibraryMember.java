package com.miu;
import java.io.*;
import java.util.List;

public class LibraryMember extends UserRole implements Serializable {
    private static final long serialVersionUID = 1L; // Optional, for version control
    private int memberId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<BookCopy> bookCopyList;
    private Address address;
    private String roleName;

    // Constructors, getters, and setters
    public LibraryMember(int memberId, String firstName,String lastName,String phoneNumber,Address address,String roleName) {
        super(roleName);
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

}