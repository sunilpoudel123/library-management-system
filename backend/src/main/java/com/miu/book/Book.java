package com.miu.book;

import com.miu.dao.BookDao;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.Author;
import com.miu.util.HelperUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements BookInterface, Serializable {
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Book saveBook(Book book) {
        BookDao.save(book);
        System.out.println("Book saved");
        return book;
    }

    public static Book findByIsbn(String isbn) {
        Book book = BookDao.findByIsbn(isbn);
        System.out.println("Book saved");
        return book;
    }

    public static List<Book> findAllBooks() {
        List<Book> book = BookDao.getAllBooks();
        System.out.println("Book retrieved: ");
        return book;
    }

}