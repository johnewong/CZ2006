package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.AccountService;
import com.example.demo.pojo.User;
import java.util.List;
@Api(tags = "Account management")
@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @ApiOperation(value = "api to edit profile")
    @GetMapping("/user/profile")
    public User editProfile() throws Exception {
        return null;
    }

    @ApiOperation(value = "api to get all users")
    @GetMapping("/user/all")
    public List<User> listAll() throws Exception {

       System.out.println("get all user api !!");

        return accountService.listAll();
    }

    @ApiOperation(value = "api to get all exists users")
    @GetMapping("/user")
    public List<User> list() throws Exception {
        return accountService.list();
    }

    @ApiOperation(value = "api to get a user by username", notes = "", response = User.class)
    @GetMapping("/user/name/{name}")
    public User getByUserName(@PathVariable("name") String name) throws Exception {
        User user = accountService.getByUserName(name);
        return user;
    }

    @ApiOperation("api to add a user - UserType: 0 = patient, 1= admin; Gender: 0 = Male, 1 = Female")
    @PostMapping("/user")
    public Object add(@RequestBody User user) throws Exception {

        accountService.add(user);
        return new ResponseEntity("User registered successfully", HttpStatus.OK);
    }



}
