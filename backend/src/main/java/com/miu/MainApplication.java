package com.miu;
import com.miu.factory.MemberFactory;

public class MainApplication {

    public static void main(String[] args) {
   /*     System.out.println("Library Management System Running .... ");
        System.out.println("#### Default Users are adding #####");
        PopulateDataUtil.addUsers();

        System.out.println("## Users are add successful ##");
        System.out.println("### Please login your username for testing: ###");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password for testing:");
        String password = scanner.nextLine();
        User user = DataStorage.testLogin(username, password);
        if (user == null) {
            System.out.println("Invalid username or password");
        } else {
            System.out.println("Login Successful for : " + user);
        } */

        //(int userId, String userName, String password, int memberId, String firstName, String lastName, String phoneNumber, Address address)

         Address add1 = new Address("Street1", "Fairfield", "Iowa", "52555");
         LibraryMember member=  MemberFactory.addLibrarianMember(1,"tag","aung", "6412332028",add1);
         System.out.println(member.getFirstName());
         System.out.println(member.findMember(1));

       //    factory.addMember("keang", "hua", "6412332028", "member","Street1", "Fairfield", "Iowa", "52555");
       // LibraryMember m=factory.findMember(39);
        /*
        LibraryMemberInterface factory = new LibraryMemberFactory();
        factory.addMember("keang", "hua", "6412332028", "member","Street1", "Fairfield", "Iowa", "52555");
        LibraryMember m=factory.findMember(39);

        if(m == null){
            System.out.printf("not found");
        } else {
            System.out.println(m.getFirstName() +m.getLastName());
        }*/
    }
}
