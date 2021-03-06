package com.example.demo.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.User;

import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    List<User> findAllByIsDeletedFalse(Sort sort);

    User findByUserNameIsDeletedFalse(String userName);
}