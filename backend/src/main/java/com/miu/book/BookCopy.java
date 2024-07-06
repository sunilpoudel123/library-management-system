package com.miu.book;

import com.miu.util.HelperUtil;

public class BookCopy{
    private String bookCopyId;
    private boolean isAvailable;
    public BookCopy(){
        this.bookCopyId = HelperUtil.generateID();
        this.isAvailable = true;
    }
}