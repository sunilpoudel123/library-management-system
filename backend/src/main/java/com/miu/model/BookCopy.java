package com.miu.model;

import java.util.Date;
public class BookCopy extends Book {
    private String bookCopyId;
    private int copyNumber;
    private boolean isAvailable;
    private Date dueDate;
    private String title;
    private String isbn;
    private int borrowedPeriod;

    public BookCopy(String bookCopyId,int copyNumber,boolean isAvailable,Date dueDate,String title,String isbn,int borrowedPeriod){
        super(title,isbn,borrowedPeriod);
        this.bookCopyId =  bookCopyId;
        this.copyNumber = copyNumber;
        this.isAvailable = isAvailable;
        this.dueDate = dueDate;
    }

    public String getBookCopyId(){
        return bookCopyId;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public  Date getDueDate(){
        return dueDate;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public void setCopyNumber(int copyNumber){
        this.copyNumber = copyNumber;
    }

    public  void setAvailableStatus(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    }
}