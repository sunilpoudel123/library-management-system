package com.miu.checkout;

import com.miu.book.BookCopy;
import com.miu.dao.CheckoutRecordEntryDao;
import com.miu.person.LibraryMember;
import com.miu.util.HelperUtil;

import java.util.Date;
import java.io.Serializable;
public class CheckoutRecordEntry  implements Serializable {

    private int checkoutRecordId;
    private LibraryMember member;
    private BookCopy bookCopy;
    private Date checkoutDate;
    private Date dueDate;
    private Date paidDate;
    private double fine;


    public CheckoutRecordEntry(LibraryMember member, BookCopy bookCopy, Date dueDate) {
        this.checkoutRecordId = HelperUtil.generateID();
        this.member = member;
        this.bookCopy = bookCopy;
        this.checkoutDate = new Date();
        this.dueDate = dueDate;
    }

    public int getCheckoutRecordId(){
        return this.checkoutRecordId;
    }

    public LibraryMember getMember() {
        return member;
    }
    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public Date getCheckoutDate() {
        return this.checkoutDate;
    }
    public Date getDueDate() {
        return this.dueDate;
    }
    public Date getPaidDate() {
        return this.paidDate;
    }
    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }
    public double getFine(){
        return  this.fine;
    }
    public void setFine(double fine){
        this.fine =  fine;
    }

    public static CheckoutRecordEntry addCheckoutRecordEntry(CheckoutRecordEntry checkEntry) {
        return  CheckoutRecordEntryDao.addCheckoutEntry(checkEntry);
    }

    public static CheckoutRecordEntry findCheckoutEntry(int memberId) {
        return CheckoutRecordEntryDao.findCheckoutRecord(memberId);
    }

    public static CheckoutRecordEntry findCheckoutEntry(int memberId, String isbn) {
        return CheckoutRecordEntryDao.findCheckoutRecord(memberId,isbn);
    }

}
