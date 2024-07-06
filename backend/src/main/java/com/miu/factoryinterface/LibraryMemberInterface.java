package com.miu.factoryinterface;
import com.miu.LibraryMember;
public interface LibraryMemberInterface {
     boolean addMember(String firstName, String lastName, String phoneNumber,String roleName,String street, String city, String state, String zip) ;

    LibraryMember findMember(int memberId);
}
