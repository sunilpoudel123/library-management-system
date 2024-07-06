package com.miu.dao;

import com.miu.book.Book;
import com.miu.book.BookCopy;
import com.miu.dataStorage.DataStorage;

import java.util.HashMap;
import java.util.Map;

public class BookDao {
    private static Map<String, Book> books = new HashMap<>();

    public BookDao() {
        Map<Object, Object> loadedData = readDatabase();
        if (loadedData != null) {
            for (Map.Entry<Object, Object> entry : loadedData.entrySet()) {
                if (entry.getValue() instanceof Book) {
                    books.put((String) entry.getKey(), (Book) entry.getValue());
                }
            }
        }
    }

    private static Map<Object, Object> readDatabase() {
        DataStorage dataStorage = new DataStorage();
        Map<Object, Object> objectMap = dataStorage.read();
        return objectMap;
    }

    public static Book save(Book book) {
        Map<Object, Object> data = new HashMap<>();
//        data.put(book.getIsbn(), book);
        DataStorage.write(data);
        System.out.println("data write successfully");
        return null;
    }

    public static Book findByIsbn(String isbn) {
        return books.get(isbn);
    }

    public static Book saveBookCopy(BookCopy bookCopy) {
        Map<Object, Object> data = new HashMap<>();
//        data.put(bookCopy.getIsbn(), bookCopy);
        DataStorage.write(data);
        System.out.println("data write successfully");
        return null;
    }
}
