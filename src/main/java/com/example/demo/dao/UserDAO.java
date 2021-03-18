package com.example.demo.dao;

import com.example.demo.pojo.Appointment;
import com.example.demo.pojo.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUserNameAndIsDeletedFalse(String userName);

    User findByUserNameOrEmailAddressOrContactNumberOrIcNumberAndIsDeletedFalse(String userName, String emailAddress, String contactNUmber, String icNumber);

}