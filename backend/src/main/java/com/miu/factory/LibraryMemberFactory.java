package com.miu.factory;
import com.miu.dao.LibraryMemberDao;

public class LibraryMemberFactory  {
    private LibraryMemberDao libraryMemberDao;
    public LibraryMemberFactory() {
        this.libraryMemberDao = new LibraryMemberDao();
    }


}