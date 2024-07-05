package com.miu;
import java.io.Serializable;
import java.util.List;

public abstract class Book implements Serializable {
    private String title;
    private String isbn;
    private int borrowedPeriod;
    private List<Author> authorList;
    private List<BookCopy> bookCopyList;

    public Book(String title, String isbn, int borrowedPeriod) {
        this.title = title;
        this.isbn = isbn;
        this.borrowedPeriod = borrowedPeriod;
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
    public List<BookCopy> getBookCopyList(){
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
}