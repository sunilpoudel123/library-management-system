package com.miu.checkout;

import com.miu.dao.CheckoutRecordEntryDao;
import com.miu.dao.LibraryMemberDao;
import com.miu.person.LibraryMember;

import java.util.Date;
import java.io.*;
public class CheckoutRecordEntry  implements Serializable {
    private int memberId;
    private String isbn;
    private String bookCopyId;
    private Date checkoutDate;
    private Date dueDate;
    private Date paidDate;

    public CheckoutRecordEntry(int memberId, String isbn, String bookCopyId, Date checkoutDate, Date dueDate,Date paidDate) {
        this.memberId = memberId;
        this.isbn = isbn;
        this.bookCopyId = bookCopyId;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.paidDate = paidDate;
    }

    public int getMemberId() {
        return memberId;
    }
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getBookCopyId() {
        return bookCopyId;
    }
    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }
    public Date getCheckoutDate() {
        return checkoutDate;
    }
    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public Date getPaidDate() {
        return paidDate;
    }
    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
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
