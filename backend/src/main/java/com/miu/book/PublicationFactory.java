package com.miu.book;


import com.miu.person.Author;

import java.util.List;

public class PublicationFactory {
    public static Publication createBookWithOneAuthorAndOneBookCopied(String title, String isbn, int borrowedPeriod, Author author, BookCopy bookCopy){
        bookCopy = new BookCopy();
        return new Book(title, isbn, borrowedPeriod, author, bookCopy);
    }
    public static Publication createBookWithManyAuthorAndOneBookCopied(String title, String isbn, int borrowedPeriod, List<Author> authorList, BookCopy bookCopy){
        bookCopy = new BookCopy();
        return new Book(title, isbn, borrowedPeriod, authorList, bookCopy);
    }
    public static Publication createBookWithOneAuthorAndManyBookCopied(String title, String isbn, int borrowedPeriod, Author author, List<BookCopy> bookCopyList){
        return new Book(title, isbn, borrowedPeriod, author, bookCopyList);
    }
    public static Publication createBookWithManyAuthorAndManyBookCopied(String title, String isbn, int borrowedPeriod, List<Author> authorList, List<BookCopy> bookCopyList){
        return new Book(title, isbn, borrowedPeriod, authorList, bookCopyList);
    }
}
