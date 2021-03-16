package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(tags = "Dashboard account management")
@RestController
@RequestMapping(value = "dashaccount")
public class DashboardAccountController {
    @Autowired
    AccountService accountService;

    @ApiOperation("api to add a user - UserType: 0 = patient, 1= admin; Gender: 0 = Male, 1 = Female")
    @PostMapping("/user")
    public Object add(@RequestBody User user) throws Exception {

        accountService.add(user);
        return new ResponseEntity("User registered successfully", HttpStatus.OK);
    }


    @ApiOperation(value = "api to get a user by username", notes = "", response = User.class)
    @GetMapping("/user/name/{name}")
    public User getByUserName(@PathVariable("name") String name) throws Exception {
        User user = accountService.getByUserName(name);
        return user;
    }
}
