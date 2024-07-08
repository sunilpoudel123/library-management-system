package com.miu.factory;

import com.miu.book.BookCopy;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.person.LibraryMember;

import java.util.Date;

public class CheckoutFactory{
public static CheckoutRecordEntry addNewCheckoutRecordEntry(LibraryMember member, BookCopy bookCopy, Date dueDate) {
    return new CheckoutRecordEntry( member,  bookCopy, dueDate);
}
}
