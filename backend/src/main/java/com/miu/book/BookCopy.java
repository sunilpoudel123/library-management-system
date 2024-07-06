package com.miu.book;

import com.miu.person.Author;
import com.miu.util.HelperUtil;

public class BookCopy extends Book{
    private String bookCopyId;
    private boolean isAvailable;
    private Book book;

    public BookCopy(){
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
    public void setBook(Book book){
        this.book = book;
    }
    public static void main(String[] args) {
        BookCopy bookCopy = new BookCopy();
        Author author = new Author("","", "", "","", null);
        Book book = (Book) PublicationFactory.createBook("MPP", "16855", 7, author, bookCopy);
        bookCopy.setBook(book);
    }
}