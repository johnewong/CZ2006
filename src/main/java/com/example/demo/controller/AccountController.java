package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.EmailService;
import java.util.List;


@Api(tags = "Account management")
@RestController
@RequestMapping(value = "account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    EmailService emailService;

    @ApiOperation(value = "api to login")
    @PostMapping("/user/login")
    public Object login(@RequestBody LoginInfo loginInfo) throws Exception {
        boolean state = accountService.login(loginInfo.username, loginInfo.password);
        return state;
    }

    @ApiOperation(value = "api to edit profile")
    @PostMapping("/user/profile")
    public Object editProfile(@RequestBody User user) throws Exception {
        accountService.save(user);
        return new ResponseEntity("User registered successfully", HttpStatus.OK);
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

    @ApiOperation("api to forget password function")
    @PostMapping("/user/forgetpassword")
    public Object forgetpassword(@RequestBody EmailInfo email) throws Exception {
        String emailaddress = email.getEmailaddress();
        String newpassword = accountService.generateStrongPassword();
        String subject = "AppName";
        String body = "Dear customer, \n\nLogin with the new password: " + newpassword;
        emailService.send(emailaddress,subject,body);
        return newpassword;
    }
}

class LoginInfo{
    String username;
    String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}

class EmailInfo{

    String emailaddress;
    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }


}