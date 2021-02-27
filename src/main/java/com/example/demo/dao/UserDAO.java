package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

public interface UserDAO extends JpaRepository<User,Integer>{

    public User findByUserName(String userName);
}