package com.example.demo.pojo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private int userID;

    @Column(name = "username")
    private String userName;

    public int getId() {
        return userID;
    }
    public void setId(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }
    public void setName(String userName) {
        this.userName = userName;
    }
}
