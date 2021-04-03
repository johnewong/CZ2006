package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.AccountService;
import com.example.demo.service.EmailService;
import com.example.demo.utility.EncryptionUtil;
import com.example.demo.utility.RoleType;
import com.example.demo.viewmodel.EmailInfo;
import com.example.demo.viewmodel.LoginInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    /**
     * This method determines whether the username and password are correct for login.
     * @param loginInfo the input username and password.
     * @return related user or show message"Credential not valid".
     */
    public Object login(@RequestBody LoginInfo loginInfo) throws Exception {
        User UserModel = accountService.login(loginInfo.getUsername(), loginInfo.getPassword(), RoleType.Customer.name());
        if (UserModel == null) {
            return new ResponseEntity("Credential not valid", HttpStatus.FORBIDDEN);

        }
        return UserModel;

    }

    @ApiOperation(value = "api to edit profile")
    @PostMapping("/user/profile")
    /**
     * This method updates a edited user profile.
     * @param user the edited user profile.
     * @return message "User profile updated successfully".
     */
    public Object editProfile(@RequestBody User user) throws Exception {
        accountService.save(user);
        return new ResponseEntity("User profile updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "api to get all users")
    @GetMapping("/user/all")
    /**
     * This method gets all users
     * @return all users
     */

    public List<User> listAll() throws Exception {

        System.out.println("get all user api !!");

        return accountService.listAll();
    }

    @ApiOperation(value = "api to get a user by username", notes = "", response = User.class)
    @GetMapping("/user/name/{name}")
    /**
     * This method gets a user by username.
     * @param name username.
     * @return user.
     */

    public User getByUserName(@PathVariable("name") String name) throws Exception {
        User user = accountService.getByUserName(name);
        return user;
    }

    @ApiOperation("api to add a user - UserType: 0 = customer, 1= admin; Gender: 0 = Male, 1 = Female")
    @PostMapping("/user")
    /**
     * This method add new users.
     * @param user new user information.
     * @return message "New user added successfully" or "User is existed".
     */
    public Object add(@RequestBody User user) throws Exception {
        boolean status = accountService.add(user);
        if (status) {
            return new ResponseEntity("New user added successfully", HttpStatus.OK);
        }

        return new ResponseEntity("User is existed", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation("api to forget password function")
    @PostMapping("/user/forgetpassword")
    /**
     * This method sends new password to user email.
     * @param email the email address which will receive the new password.
     * @return message "Sent".
     */

    public Object forgetpassword(@RequestBody EmailInfo email) throws Exception {
        String emailaddress = email.getEmailaddress();
        User user = accountService.getByEmailAndType(emailaddress, RoleType.Customer.toInt());
        if(user == null){

            return new ResponseEntity("user not exist", HttpStatus.BAD_REQUEST);
        }else{

            String newpassword = accountService.generateStrongPassword();

            String subject = "AppName";
            String body = "Dear customer, \n\nLogin with the new password: " + newpassword;

            newpassword = EncryptionUtil.encryptPassword(newpassword);

            user.setPassword(newpassword);
            accountService.save(user);

            emailService.send(emailaddress, subject, body);
            return new ResponseEntity("Sent", HttpStatus.OK);
        }

    }



    
}
