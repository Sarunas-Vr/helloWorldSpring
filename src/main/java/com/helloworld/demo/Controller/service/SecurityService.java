package com.helloworld.demo.Controller.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
