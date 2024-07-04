package com.miu.service;

import com.miu.model.User;

public interface UserService {

    User login();
    User findByUsername(String username);

}
