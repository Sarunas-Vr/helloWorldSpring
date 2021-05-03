package com.helloworld.demo.Controller.service;

import com.helloworld.demo.Controller.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
