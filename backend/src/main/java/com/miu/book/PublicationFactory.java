package com.miu.book;


import com.miu.person.Author;
import com.miu.util.HelperUtil;

import java.util.List;

public class PublicationFactory {
    public static Publication createBook(String title, String isbn, int borrowedPeriod, Author author, BookCopy bookCopy){
        Book book = new Book(title, isbn, borrowedPeriod, author, bookCopy);
        bookCopy.setBook(book);
        return book;
    }
    public static Publication createBook(String title, String isbn, int borrowedPeriod, List<Author> authorList, BookCopy bookCopy){
        return new Book(title, isbn, borrowedPeriod, authorList, bookCopy);
    }
    public static Publication createBook(String title, String isbn, int borrowedPeriod, Author author, List<BookCopy> bookCopyList){
        return new Book(title, isbn, borrowedPeriod, author, bookCopyList);
    }
    public static Publication createBook(String title, String isbn, int borrowedPeriod, List<Author> authorList, List<BookCopy> bookCopyList){
        return new Book(title, isbn, borrowedPeriod, authorList, bookCopyList);
    }
}
