package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.UserService;
import com.example.demo.pojo.User;

import java.util.List;


@RestController
public class AccountController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> list() throws Exception {
        return userService.list();
    }
}
