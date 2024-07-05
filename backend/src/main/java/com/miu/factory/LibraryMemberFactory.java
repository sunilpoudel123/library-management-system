package com.miu.factory;
import com.miu.Address;
import com.miu.LibraryMember;
import com.miu.dao.LibraryMemberDao;
import com.miu.factoryinterface.LibraryMemberInterface;

public class LibraryMemberFactory implements LibraryMemberInterface {
    private LibraryMemberDao libraryMemberDao;

    public LibraryMemberFactory() {
        this.libraryMemberDao = new LibraryMemberDao();
    }

    @Override
    public boolean addMember(int memberId, String firstName, String lastName, String phoneNumber,String roleName,String street, String city, String state, String zip) {
        Address address=new Address( street,  city,  state,  zip);
        LibraryMember member=new LibraryMember(memberId,firstName,lastName,phoneNumber,address,roleName);
        return libraryMemberDao.addMember(member);
    }


}