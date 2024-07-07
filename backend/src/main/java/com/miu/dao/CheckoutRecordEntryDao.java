package com.miu.dao;

import com.miu.book.BookCopy;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.person.LibraryMember;

import java.io.Serializable;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import java.util.ArrayList;

public final class CheckoutRecordEntryDao<T extends Serializable> {
    private static Map<Integer, CheckoutRecordEntry> entries = new HashMap<>();
    private static Map<String, BookCopy> copies = new HashMap<>();
    static {
        loadData();
        loadCopiesData();
    }

    private static void loadData() {
        HashMap<Integer, CheckoutRecordEntry> loadedData = DataStorageFacade.readEntryMap();
        if (loadedData != null) {
            for (Map.Entry<Integer, CheckoutRecordEntry> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof CheckoutRecordEntry) {
                    entries.put(entry.getKey(), (CheckoutRecordEntry) entry.getValue());
                }
            }
        }
    }

    private static void loadCopiesData() {
        HashMap<String, BookCopy> loadedData = DataStorageFacade.readBookCopyMap();
        if (loadedData != null) {
            for (Map.Entry<String, BookCopy> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof BookCopy) {
                    copies.put(entry.getKey(), (BookCopy) entry.getValue());
                }
            }
        }
    }

    public static CheckoutRecordEntry findCheckoutRecord(int memberId) {
        for (Map.Entry<Integer, CheckoutRecordEntry> entry : entries.entrySet()) {
            System.out.println(entry.getValue().getMemberId() + " Checkout Record Entry" + entry.getValue().getIsbn());
            if (entry.getValue().getMemberId() == memberId) {
                return entry.getValue();
            }
        }
        return null;
    }


    public static List<CheckoutRecordEntry> getCheckoutRecord() {
        List<CheckoutRecordEntry> checkoutRecords = new ArrayList<>();
        for (Map.Entry<Integer, CheckoutRecordEntry> entry : entries.entrySet()) {
          //  System.out.println(entry.getValue().getMemberId() + " Checkout Record Entry " + entry.getValue().getIsbn());
            checkoutRecords.add(entry.getValue());
        }
        return checkoutRecords;
    }


    public static CheckoutRecordEntry findCheckoutRecord(int memberId, String isbn) {
        for (Map.Entry<Integer, CheckoutRecordEntry> entry : entries.entrySet()) {
            if (entry.getValue().getMemberId() == memberId && entry.getValue().getIsbn().equals(isbn)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public static CheckoutRecordEntry addCheckoutEntry(CheckoutRecordEntry checkoutEntry) {
        BookCopy bookCopy = copies.get(checkoutEntry.getIsbn());
        editBookAvailabilty(bookCopy);
        DataStorageFacade.saveNewCheckoutEntry(checkoutEntry);
        loadData();
        System.out.println("Checkout record write successfully");
        for (Map.Entry<Integer, CheckoutRecordEntry> entry : entries.entrySet()) {
            if (entry.getValue().getMemberId() == checkoutEntry.getMemberId() && entry.getValue().getIsbn().equals(checkoutEntry.getIsbn())) {
                return entry.getValue();
            }
        }
        return null;
    }

    private static void editBookAvailabilty(BookCopy bookCopy) {
        System.out.println("Updating Book Copy with ID: " + bookCopy.getBookCopyId());
        HashMap<String, BookCopy> loadedData = DataStorageFacade.readBookCopyMap();
            if(copies!=null && copies.containsKey(bookCopy.getBookCopyId())) {
                for (Map.Entry<String, BookCopy> entry : copies.entrySet()) {
                    if (entry.getValue() instanceof BookCopy) {
                        BookCopy bookCopy1 = entry.getValue();
                        bookCopy1.setIsAvailable(false);
                        if (bookCopy.getBookCopyId().equals(bookCopy1.getBookCopyId())) {
                            entry.setValue(bookCopy);
                            DataStorageFacade.saveNewBookCopy(bookCopy);
                            loadCopiesData();
                        }
                    }
                }
            }
    }

}

