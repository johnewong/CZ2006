package com.example.demo.service;

import java.util.List;

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
        userDAO.save(user);
    }

    public User getByUserName(String name) {
        return userDAO.findByUserNameAndIsDeletedFalse(name);
    }
}