package com.miu.util;

import com.miu.model.User;

import java.util.ArrayList;
import java.util.List;

public class PopulateDataUtil {

    public static void addUsers() {

        List<User> users = new ArrayList<>();

        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        adminUser.setFirstName("Admin");
        adminUser.setLastName("Person");
        users.add(adminUser);

        User libraryUser = new User();
        libraryUser.setUsername("librarian");
        libraryUser.setPassword("librarian");
        libraryUser.setFirstName("Library");
        libraryUser.setLastName("Person");
        users.add(libraryUser);

        HelperUtil.save(users);

    }

}
