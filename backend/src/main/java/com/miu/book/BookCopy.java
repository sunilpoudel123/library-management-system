package com.miu.book;

import com.miu.dao.BookDao;
import com.miu.person.Author;
import com.miu.util.HelperUtil;

import java.util.ArrayList;
import java.util.List;

public class BookCopy extends Book {
    private String bookCopyId;
    private boolean isAvailable;
    private Book book;

    //Book with 1 Author & 1 Copy
    public BookCopy(String title, String isbn, int borrowedPeriod, Author author, BookCopy bookCopy) {
        super.bookId = HelperUtil.generateStringID();
        this.title = title;
        this.isbn = isbn;
        this.authorList = new ArrayList<>();
        this.authorList.add(author);
        this.bookCopyList = new ArrayList<>();
        this.bookCopyList.add(bookCopy);
    }

    //Book with * Authors & 1 Copy
    public BookCopy(String title, String isbn, int borrowedPeriod, List<Author> authorList, BookCopy bookCopy) {
        this.bookId = HelperUtil.generateStringID();
        this.title = title;
        this.isbn = isbn;
        this.authorList = authorList;
        this.bookCopyList = new ArrayList<>();
        this.bookCopyList.add(bookCopy);
    }

    //Book with 1 Author & * Copies
    public BookCopy(String title, String isbn, int borrowedPeriod, Author author, List<BookCopy> bookCopyList) {
        this.bookId = HelperUtil.generateStringID();
        this.title = title;
        this.isbn = isbn;
        this.authorList = new ArrayList<>();
        this.authorList.add(author);
        this.bookCopyList = new ArrayList<>();
        this.bookCopyList = bookCopyList;
    }

    //Book with * Authors & * Copies
    public BookCopy(String title, String isbn, int borrowedPeriod, List<Author> authorList, List<BookCopy> bookCopyList) {
        this.bookId = HelperUtil.generateStringID();
        this.title = title;
        this.isbn = isbn;
        this.borrowedPeriod = borrowedPeriod;
        this.authorList = authorList;
        this.bookCopyList = bookCopyList;
    }

    public BookCopy() {
        this.bookCopyId = HelperUtil.generateStringID();
        this.isAvailable = true;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return this.book;
    }

    public static Book saveBookCopy(BookCopy book) {
        BookDao.saveBookCopy(book);
        System.out.println("Book saved");
        return book;
    }
}