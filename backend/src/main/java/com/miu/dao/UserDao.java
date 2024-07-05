package com.miu.dao;

import com.miu.model.User;

public interface UserDao {

    User login(String username, String password);

    User findByUsername(String username);

    User findById(int id);

    User save(User user);

}
