package com.miu.book;

import com.miu.dao.BookDao;
import com.miu.person.Author;
import com.miu.util.HelperUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Publication, Serializable {
    private String bookId;
    private String title;
    private String isbn;
    private int borrowedPeriod;

    private List<Author> authorList;
    private List<BookCopy> bookCopyList;

    //Book with 1 Author & 1 Copy
    public Book(String title, String isbn, int borrowedPeriod, Author author, BookCopy bookCopy) {
        this.bookId = HelperUtil.generateID();
        this.title = title;
        this.isbn = isbn;
        this.authorList = new ArrayList<>();
        this.authorList.add(author);
        this.bookCopyList = new ArrayList<>();
        this.bookCopyList.add(bookCopy);
    }

    //Book with * Authors & 1 Copy
    public Book(String title, String isbn, int borrowedPeriod, List<Author> authorList, BookCopy bookCopy) {
        this.bookId = HelperUtil.generateID();
        this.title = title;
        this.isbn = isbn;
        this.authorList = authorList;
        this.bookCopyList = new ArrayList<>();
        this.bookCopyList.add(bookCopy);
    }

    //Book with 1 Author & * Copies
    public Book(String title, String isbn, int borrowedPeriod, Author author, List<BookCopy> bookCopyList) {
        this.bookId = HelperUtil.generateID();
        this.title = title;
        this.isbn = isbn;
        this.authorList = new ArrayList<>();
        this.authorList.add(author);
        this.bookCopyList = new ArrayList<>();
        this.bookCopyList = bookCopyList;
    }

    //Book with * Authors & * Copies
    public Book(String title, String isbn, int borrowedPeriod, List<Author> authorList, List<BookCopy> bookCopyList) {
        this.bookId = HelperUtil.generateID();
        this.title = title;
        this.isbn = isbn;
        this.borrowedPeriod = borrowedPeriod;
        this.authorList = authorList;
        this.bookCopyList = bookCopyList;
    }
    public void addBookCopy(int numberOfNewCopy) {
        for(int i = 0; i < numberOfNewCopy; i++) {

        }
    }
    public int numberOfAuthor(){
        return authorList.size();
    }
    public int numberOfBookCopy(){
        return bookCopyList.size();
    }
}