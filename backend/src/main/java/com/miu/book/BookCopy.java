package com.miu.book;

import com.miu.person.Author;
import com.miu.util.HelperUtil;

public class BookCopy extends Book{
    private String bookCopyId;
    private boolean isAvailable;
    private Book book;

    public BookCopy(){
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
    public void setBook(Book book){
        this.book = book;
    }
}