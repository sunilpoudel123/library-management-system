package com.miu.model;

import java.util.Date;

public class CheckoutRecordEntry {
    private String memberId;
    private String isbn;
    private String bookCopyId;
    private Date checkoutDate;
    private Date dueDate;
    private Date paidDate;

    public CheckoutRecordEntry(String memberId, String isbn, String bookCopyId, Date checkoutDate, Date dueDate,Date paidDate) {
        this.memberId = memberId;
        this.isbn = isbn;
        this.bookCopyId = bookCopyId;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.paidDate = paidDate;
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
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
}
