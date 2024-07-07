package com.miu;
import com.miu.dao.LibraryMemberDao;
import com.miu.factory.MemberFactory;
import com.miu.util.HelperUtil;

public class MainApplication {

    public static void main(String[] args) {
        Address add1 = new Address("Street1", "Fairfield", "Iowa", "52555");
        LibraryMember member=  MemberFactory.addLibrarianMember("Ma Ma","Toe Toe", "## 6412332028",add1);
        LibraryMember.addMember(member);

        LibraryMember member2= LibraryMember.findMember(member.getMemberId());
        System.out.println("Before updated by finding member." + member2.getFirstName() + " : " +member.getMemberId());

        member2.setFirstName("HHHHH");
        LibraryMember member3=LibraryMember.editMember(member2);

        System.out.println("After updated by finding member." + member3.getFirstName() + " : " + member3.getMemberId());
    }
}
