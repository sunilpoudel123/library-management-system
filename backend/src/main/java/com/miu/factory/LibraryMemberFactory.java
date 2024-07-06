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
    public boolean addMember(String firstName, String lastName, String phoneNumber,String roleName,String street, String city, String state, String zip) {
        Address address = new Address(street, city, state, zip);
        int maxMemberId = libraryMemberDao.findMaximumMemberId();
        System.out.println(maxMemberId);
        LibraryMember member = new LibraryMember(maxMemberId + 1, firstName, lastName, phoneNumber, address, roleName);
        return libraryMemberDao.addMember(member);
    }

    public LibraryMember findMember(int memberId){
     return libraryMemberDao.findMember(memberId);
    }

}