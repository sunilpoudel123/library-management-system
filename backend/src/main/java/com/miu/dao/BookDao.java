package com.miu.dao;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.checkout.CheckoutRecordEntry;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.User;

import java.util.*;

public class BookDao {
    private static Map<String, Book> books = new HashMap<>();
    private static Map<String, BookCopy> bookCopies = new HashMap<>();

    static {
        loadData();
    }

    private static void loadData() {
        HashMap<String, Book> loadedData = DataStorageFacade.readBooksMap();
        if (loadedData != null) {
            books.clear();
            for (Map.Entry<String, Book> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof Book) {
                    books.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    private static void loadBookCopiesData() {
        HashMap<String, BookCopy> loadedData = DataStorageFacade.readBookCopyMap();
        if (loadedData != null) {
           bookCopies.clear();
            for (Map.Entry<String, BookCopy> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof BookCopy) {
                    bookCopies.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static Book addBook(Book book) {
        DataStorageFacade.saveNewBook(book);
        loadData();
        System.out.println("Book data write successfully");
        return book;
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public static Book findBook(String isbn) {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getISBN().equals(isbn)) {
                return entry.getValue();
            }
        }
        System.out.println("Not found book");
        return null;
    }

    public static BookCopy addBookCopy(BookCopy bookCopy) {
        DataStorageFacade.saveNewBookCopy(bookCopy);
        loadBookCopiesData();
        System.out.println("BookCopy write successfully");
        return bookCopy;
    }

    public static int checkAvailableCopyQty(String isbn) {
        int availableQty = 0;
        for (Map.Entry<String, BookCopy> entry : bookCopies.entrySet()) {
            if(entry.getValue().getISBN().equals(isbn) &&  entry.getValue().getIsAvailable()){
                availableQty++;
            }
        }
        return availableQty;
    }

    public static BookCopy checkAvailableCopy(String copyId) {
        for (Map.Entry<String, BookCopy> entry : bookCopies.entrySet()) {
            if (entry.getValue().getBookCopyId().equals(copyId)) {
                return entry.getValue();
            }
        }
        System.out.println("Not found book");
        return null;
    }

}
