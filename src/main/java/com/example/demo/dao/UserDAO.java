package com.example.demo.dao;

import com.example.demo.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUserNameAndUserTypeAndIsDeletedFalse(String userName,Integer userType);

    User findByUserNameAndIsDeletedFalse(String userName);
    User findByUserIDAndIsDeletedFalse(Integer userID);
    User findByEmailAddressAndUserTypeAndIsDeletedFalse(String email,Integer userType);

    User findByUserNameOrEmailAddressOrIcNumber(String userName, String emailAddress, String icNumber);

}