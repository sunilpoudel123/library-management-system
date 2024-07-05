package com.miu.util;

import com.miu.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopulateDataUtil {

    public static void addUsers() {

        Map<Object, Object> data = new HashMap<>();

        User adminUser = new User();
        adminUser.setUsername("admin");
        adminUser.setPassword("admin");
        adminUser.setFirstName("Admin");
        adminUser.setLastName("Person");
        data.put(adminUser.getUsername(), adminUser);

        User libraryUser = new User();
        libraryUser.setUsername("librarian");
        libraryUser.setPassword("librarian");
        libraryUser.setFirstName("Library");
        libraryUser.setLastName("Person");
        data.put(libraryUser.getUsername(), libraryUser);

        HelperUtil.save(data);
        System.out.println("Data has been populated and saved to the file.");

    }
}
