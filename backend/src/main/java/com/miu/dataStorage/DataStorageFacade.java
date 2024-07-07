package com.miu.dataStorage;

import com.miu.book.Book;
import com.miu.person.LibraryMember;
import com.miu.person.Member;
import com.miu.person.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import com.miu.checkout.CheckoutRecord;
import com.miu.checkout.CheckoutRecordEntry;

public class DataStorageFacade {

    enum StorageType {
        BOOKS, MEMBERS, USERS, ENTRIES;
    }

    public static final String OUTPUT_DIR = System.getProperty("user.dir") + "/resources/database/bin";
    public static final String DATE_PATTERN = "MM/dd/yyyy";

    //implement: other save operations
    public static void saveNewMember(LibraryMember member) {
        HashMap<Integer, LibraryMember> mems = readMemberMap();
        Integer memberId = member.getMemberId();
        mems.put(memberId, member);
        saveToStorage(StorageType.MEMBERS, mems);
    }

    public static void saveNewBook(Book book) {
        HashMap<String, Book> books = readBooksMap();
        String isbn = book.getISBN();
        books.put(isbn, book);
        saveToStorage(StorageType.BOOKS, books);
    }

    public static void saveNewUser(User user) {
        HashMap<Integer, User> books = readUserMap();
        int userId = user.getId();
        books.put(userId, user);
        saveToStorage(StorageType.USERS, books);
    }

    public static void saveNewCheckoutEntry(CheckoutRecordEntry recordEntry) {
        HashMap<Integer, CheckoutRecordEntry> recordEntries = new HashMap<>();
        /// int memberId = recordEntry.getMemberId();
        recordEntries.put(1, recordEntry);
        saveToStorage(StorageType.ENTRIES, recordEntries);
    }


    @SuppressWarnings("unchecked")
    public static HashMap<String, Book> readBooksMap() {
        //Returns a Map with name/value pairs being
        //   isbn -> Book
        return (HashMap<String, Book>) readFromStorage(StorageType.BOOKS);
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, LibraryMember> readMemberMap() {
        //Returns a Map with name/value pairs being
        //   memberId -> LibraryMember
        return (HashMap<Integer, LibraryMember>) readFromStorage(
                StorageType.MEMBERS);
    }


    @SuppressWarnings("unchecked")
    public static HashMap<Integer, User> readUserMap() {
        //Returns a Map with name/value pairs being
        //   userId -> User
        return (HashMap<Integer, User>) readFromStorage(StorageType.USERS);
    }

    public static HashMap<Integer, CheckoutRecordEntry> readEntryMap() {
        //Returns a Map with name/value pairs being
        //   memberId -> LibraryMember
        return (HashMap<Integer, CheckoutRecordEntry>) readFromStorage(
                StorageType.ENTRIES);
    }


    /////load methods - these place test data into the storage area
    ///// - used just once at startup

    public static void loadBookMap(List<Book> bookList) {
        HashMap<String, Book> books = new HashMap<String, Book>();
        bookList.forEach(book -> books.put(book.getISBN(), book));
        saveToStorage(StorageType.BOOKS, books);
    }

    public static void loadUserMap(List<User> userList) {
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        userList.forEach(user -> users.put(user.getId(), user));
        saveToStorage(StorageType.USERS, users);
    }

    public static void loadMemberMap(List<Member> memberList) {
        HashMap<Integer, Member> members = new HashMap<Integer, Member>();
        memberList.forEach(member -> members.put(((LibraryMember)member).getMemberId(), member));
        saveToStorage(StorageType.MEMBERS, members);
    }

    public static void loadCheckoutMap(List<CheckoutRecordEntry> entryList) {
        HashMap<Integer, CheckoutRecordEntry> entries = new HashMap();
        entryList.forEach(entry -> entries.put(((CheckoutRecordEntry)entry).getMemberId(), entry));
        saveToStorage(StorageType.ENTRIES, entries);
    }


    static void saveToStorage(StorageType type, Object ob) {
        ObjectOutputStream out = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
            out = new ObjectOutputStream(Files.newOutputStream(path));
            out.writeObject(ob);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                }
            }
        }
    }

    static Object readFromStorage(StorageType type) {
        ObjectInputStream in = null;
        Object retVal = null;
        try {
            Path path = FileSystems.getDefault().getPath(OUTPUT_DIR, type.toString());
            in = new ObjectInputStream(Files.newInputStream(path));
            retVal = in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
        }
        return retVal;
    }


    final static class Pair<S, T> implements Serializable {
        S first;
        T second;

        Pair(S s, T t) {
            first = s;
            second = t;
        }

        @Override
        public boolean equals(Object ob) {
            if (ob == null) return false;
            if (this == ob) return true;
            if (ob.getClass() != getClass()) return false;
            @SuppressWarnings("unchecked")
            Pair<S, T> p = (Pair<S, T>) ob;
            return p.first.equals(first) && p.second.equals(second);
        }

        @Override
        public int hashCode() {
            return first.hashCode() + 5 * second.hashCode();
        }

        @Override
        public String toString() {
            return "(" + first.toString() + ", " + second.toString() + ")";
        }

        private static final long serialVersionUID = 5399827794066637059L;
    }

}
