package com.miu;

import com.miu.dao.BookDao;
import com.miu.dao.UserDao;
import com.miu.util.HelperUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Book implements Serializable {

    static BookDao bookDao = new BookDao();
    private String bookId;
    private String title;
    private String isbn;
    private int borrowedPeriod;
    private List<Author> authorList;
    private List<BookCopy> bookCopyList;

    public Book(String title, String isbn, int borrowedPeriod) {
        this.bookId = HelperUtil.generateStringID();
        this.title = title;
        this.isbn = isbn;
        this.borrowedPeriod = borrowedPeriod;
        this.authorList = new ArrayList<>();
        this.bookCopyList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<Author> getAuthor() {
        return authorList;
    }

    public List<BookCopy> getBookCopyList() {
        return bookCopyList;
    }

    public int getBorrowedPeriod() {
        return borrowedPeriod;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setBorrowedPeriod(int borrowedPeriod) {
        this.borrowedPeriod = borrowedPeriod;
    }

    public void addCopy(BookCopy copy) {
        bookCopyList.add(copy);
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public static Book createBook(Book book) {
        bookDao.save(book);
        return book;
    }

    public static Book findByIsbn(String isbn) {
        return bookDao.findByIsbn(isbn);
    }

}