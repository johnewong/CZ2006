package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.UserService;
import com.example.demo.pojo.User;

import java.util.List;

@Api(tags = "Account management")
@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "api to get all users")
    @GetMapping("/user/getall")
    public List<User> list() throws Exception {
        return userService.list();
    }

    @ApiOperation(value = "api to get a user by username", notes = "", response = User.class)
    @GetMapping("/user/getbyusername/{name}")
    public User get(@PathVariable("name") String name) throws Exception {
        User user = userService.getbyusername(name);
        return user;
    }

    @ApiOperation("api to add a user")
    @PostMapping("/user/add")
    public Object add(@RequestBody User user) throws Exception {
        userService.add(user);
        return user;
    }
}
