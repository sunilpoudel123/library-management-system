package com.miu.dao;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.dataStorage.DataStorage;
import com.miu.dataStorage.DataStorageFacade;
import com.miu.person.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDao {
    private static Map<String, Book> books = new HashMap<>();

    static {
        HashMap<String, Book> loadedData = DataStorageFacade.readBooksMap();
        if (loadedData != null) {
            for (Map.Entry<String, Book> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof Book) {
                    books.put((String) entry.getKey(), (Book) entry.getValue());
                }
            }
        }
    }

    public static Book save(Book book) {
        DataStorageFacade.saveNewBook(book);
        System.out.println("data write successfully");
        return null;
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public static Book findByIsbn(String isbn) {
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getISBN().equals(isbn)) {
                return entry.getValue();
            }
        }
        System.out.println("Not found book");
        return null;
    }

    public static Book saveBookCopy(BookCopy bookCopy) {
        DataStorageFacade.saveNewBook(bookCopy);
        System.out.println("data write successfully");
        return null;
    }


}
