package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{name}")
    public User get(@PathVariable("name") String name) throws Exception {
        User user=userService.get(name);
        return user;
    }

    @PostMapping("/users")
    public Object add(@RequestBody User user) throws Exception {
        userService.add(user);
        return user;
    }
}
