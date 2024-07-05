package com.miu.factory;
import com.miu.LibraryMember;
import com.miu.dao.LibraryMemberDao;
import com.miu.factoryinterface.LibraryMemberInterface;

public class LibraryMemberFactory implements LibraryMemberInterface {
    private LibraryMemberDao libraryMemberDao;

    public LibraryMemberFactory() {
        this.libraryMemberDao = new LibraryMemberDao();
    }

    @Override
    public boolean addMember(LibraryMember member) {
        return libraryMemberDao.addMember(member);
    }


}