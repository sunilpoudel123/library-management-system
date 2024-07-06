package com.miu.book;


import com.miu.person.Author;
import java.util.List;

public class PublicationFactory {
    public static Publication createBook(String title, String isbn, int borrowedPeriod, Author author, BookCopy bookCopy){
        Book book = new Book(title, isbn, borrowedPeriod, author, bookCopy);
        bookCopy.setBook(book);
        return book;
    }
    public static Publication createBook(String title, String isbn, int borrowedPeriod, List<Author> authorList, BookCopy bookCopy){
        Book book = new Book(title, isbn, borrowedPeriod, authorList, bookCopy);
        bookCopy.setBook(book);
        return book;
    }
    public static Publication createBook(String title, String isbn, int borrowedPeriod, Author author, List<BookCopy> bookCopyList){
        Book book = new Book(title, isbn, borrowedPeriod, author, bookCopyList);
        for(BookCopy bookCopy : bookCopyList){
            bookCopy.setBook(book);
        }
        return book;
    }
    public static Publication createBook(String title, String isbn, int borrowedPeriod, List<Author> authorList, List<BookCopy> bookCopyList){
        Book book = new Book(title, isbn, borrowedPeriod, authorList, bookCopyList);
        for(BookCopy bookCopy : bookCopyList){
            bookCopy.setBook(book);
        }
        return book;
    }
}
