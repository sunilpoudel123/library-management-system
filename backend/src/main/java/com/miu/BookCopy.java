package com.miu;

import com.miu.util.HelperUtil;

import java.util.UUID;

public class BookCopy extends Book {

    private String bookCopyId;
    private int copyNumber;
    private boolean isAvailable;
    private String title;
    private String isbn;
    private int borrowedPeriod;

    public BookCopy(String bookCopyId, int copyNumber, boolean isAvailable, String title, String isbn, int borrowedPeriod) {
        super(title, isbn, borrowedPeriod);
        this.bookCopyId = bookCopyId;
        this.copyNumber = copyNumber;
        this.isAvailable = isAvailable;
    }

    public String getBookCopyId() {
        return bookCopyId;
    }

    public int getCopyNumber() {
        return copyNumber;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setBookCopyId(String bookCopyId) {
        this.bookCopyId = bookCopyId;
    }

    public void setCopyNumber(int copyNumber) {
        this.copyNumber = copyNumber;
    }

    public void setAvailableStatus(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public static BookCopy addBookCopy(String isbn, int copyNumber) {
        String uniqueID = UUID.randomUUID().toString();
        Book book = findByIsbn(isbn);
        if (book == null) {
            System.out.println("Book not found");
            return null;
        }
        BookCopy bookCopy = new BookCopy(uniqueID, copyNumber, true, book.getTitle(), book.getIsbn(), book.getBorrowedPeriod());
        bookDao.saveBookCopy(bookCopy);
        return bookCopy;
    }

}