package com.miu.book;

import com.miu.person.Author;
import com.miu.util.HelperUtil;

import java.util.List;

public class BookCopy extends Book{
    private String bookCopyId;
    private boolean isAvailable;

    public BookCopy(){
        this.bookCopyId=HelperUtil.generateID();
        isAvailable = true;
    }

    public BookCopy(String title, String isbn, int borrowedPeriod, Author author, BookCopy bookCopy){
        super(title, isbn, borrowedPeriod, author, bookCopy);
        super.setBookId(HelperUtil.generateID());
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
    public BookCopy(String title, String isbn, int borrowedPeriod, List<Author> authorList, BookCopy bookCopy){
        super(title, isbn, borrowedPeriod, authorList, bookCopy);
        super.setBookId(HelperUtil.generateID());
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
    public BookCopy(String title, String isbn, int borrowedPeriod, Author author, List<BookCopy> bookCopyList){
        super(title, isbn, borrowedPeriod, author, bookCopyList);
        super.setBookId(HelperUtil.generateID());
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
    public BookCopy(String title, String isbn, int borrowedPeriod, List<Author> authorList, List<BookCopy> bookCopyList){
        super(title, isbn, borrowedPeriod, authorList, bookCopyList);
        super.setBookId(HelperUtil.generateID());
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
}