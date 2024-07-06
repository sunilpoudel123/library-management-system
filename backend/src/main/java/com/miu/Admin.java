package com.miu;
import java.io.*;
import com.miu.libraryinterface.Member;
import com.miu.User;

public class Admin extends User implements Member,Serializable {
    public Admin(int userId, String userName, String password) {
        super(userId, userName, password);
    }

    public void viewCheckoutRecord() {
        System.out.println("Viewing record: ");
    }
}