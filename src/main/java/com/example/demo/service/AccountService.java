package com.example.demo.service;

import java.util.Date;
import java.util.List;

import com.example.demo.utility.EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.dao.UserDAO;

@Service
public class AccountService {
    @Autowired UserDAO userDAO;

    public List<User> listAll() {
        return userDAO.findAll(Sort.by(Sort.Direction.DESC, "userID"));
    }

    public List<User> list() {
        return userDAO.findAllByIsDeletedFalse(Sort.by(Sort.Direction.DESC, "userID"));
    }

    public void add(User user){
        Date createdDate = new Date();

        User userModel = new User();
        userModel.setBirthDate(user.getBirthDate());
        userModel.setContactNumber(user.getContactNumber());
        userModel.setEmailAddress(user.getEmailAddress());
        userModel.setGender(user.getGender());
        userModel.setPassword(EncryptionUtil.encryptPassword(user.getPassword()));
        userModel.setUserType(user.getUserType());
        userModel.setIcNumber(user.getIcNumber());
        userModel.setCreatedBy(0);
        userModel.setCreatedDate(createdDate);
        
        userDAO.save(user);
    }

    public User getByUserName(String name) {
        return userDAO.findByUserNameAndIsDeletedFalse(name);
    }


}