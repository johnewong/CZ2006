package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.User;
import com.example.demo.dao.UserDAO;

@Service
public class UserService {
    @Autowired UserDAO userDAO;

    public List<User> list() {
        return userDAO.findAll(Sort.by(Sort.Direction.DESC, "userID"));
    }

    public void add(User user){
        userDAO.save(user);
    }

    public User get(String name) {
        return userDAO.findByUserName(name);
    }
}