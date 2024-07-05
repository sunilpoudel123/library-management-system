package com.miu;

import java.io.Serializable;
import java.util.Date;
public class BookCopy extends Book implements Serializable {
    private String bookCopyId;
    private int copyNumber;
    private boolean isAvailable;
    private String title;
    private String isbn;
    private int borrowedPeriod;

    public BookCopy(String bookCopyId,int copyNumber,boolean isAvailable,String title,String isbn,int borrowedPeriod){
        super(title,isbn,borrowedPeriod);
        this.bookCopyId =  bookCopyId;
        this.copyNumber = copyNumber;
        this.isAvailable = isAvailable;
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

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public void setCopyNumber(int copyNumber){
        this.copyNumber = copyNumber;
    }

    public  void setAvailableStatus(boolean isAvailable){
        this.isAvailable = isAvailable;
    }

}