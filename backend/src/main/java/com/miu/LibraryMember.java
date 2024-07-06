package com.miu;
import java.io.*;
import java.util.List;
import com.miu.dao.LibraryMemberDao;
import com.miu.libraryinterface.Member;

public class LibraryMember   implements Member,Serializable  {
    private static final long serialVersionUID = 1L; // Optional, for version control
    private int memberId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private List<BookCopy> bookCopyList;
    private Address address;


    LibraryMemberDao libraryMemberDao=new LibraryMemberDao();
    public LibraryMember(int memberId, String firstName, String lastName, String phoneNumber, Address address) {
        this.memberId =  libraryMemberDao.findMaxId();
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

    public LibraryMember addLibraryMember(LibraryMember libraryMember) {
        libraryMemberDao=new LibraryMemberDao();
        return libraryMemberDao.addLibraryMember(libraryMember);
    }

    public LibraryMember findMember(int memberId){
        libraryMemberDao=new LibraryMemberDao();
       return libraryMemberDao.findMember(memberId);
    }
}