package com.miu;

import java.io.*;

import com.miu.libraryinterface.Member;
import com.miu.User;

public class Librarian extends User implements Member, Serializable {

    public Librarian(int userId, String userName, String password) {
        super(userId, userName, password);
    }

    public void checkoutBook() {
        System.out.println("Book checkout");
    }

}

