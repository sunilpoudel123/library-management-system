package com.miu.book;

import com.miu.person.Author;
import com.miu.util.HelperUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements BookInterface, Serializable {
    protected String bookId;
    protected String title;
    protected String isbn;
    protected int borrowedPeriod;

    protected List<Author> authorList;
    protected List<BookCopy> bookCopyList;

    public List<BookCopy> getBookCopyList() {
        return bookCopyList;
    }

    public String getTitle() {
        return title;
    }

    public void addBookDefaultCopy(BookCopy bookCopy) {
        bookCopyList.add(bookCopy);
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int numberOfAuthor() {
        return authorList.size();
    }

    public int numberOfBookCopy() {
        return bookCopyList.size();
    }

    public String getISBN() {
        return isbn;
    }
}