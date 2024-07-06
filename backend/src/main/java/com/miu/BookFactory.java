package com.miu;


public class BookFactory {
    static Book addBook(String id, String title, String author, String isbn, int borrowedPeriod) {
        Book bookData = new BookCopy(id, 1, true, title, isbn, borrowedPeriod);
        return bookData;
    }

    static Book addBookCopy(String isbn, int numberOfCopies) {
        BookCopy bookData = BookCopy.addBookCopy(isbn, numberOfCopies);
        return bookData;
    }
}
