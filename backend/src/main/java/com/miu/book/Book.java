package com.miu.book;

import com.miu.checkout.CheckoutRecord;
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
    public Book(String isbn,String title,int borrowedPeriod,List<Author> authorList){
        this.isbn=isbn;
        this.title=title;
        this.borrowedPeriod=borrowedPeriod;
        this.authorList=authorList;
    }

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

    public static Book addBook(Book book) {
        return BookDao.addBook(book);
    }

    public static Book findBook(String isbn) {
        return BookDao.findBook(isbn);
    }

    public static List<Book> findAllBooks() {
        List<Book> bookList = BookDao.getAllBooks();
        return bookList;
    }


}