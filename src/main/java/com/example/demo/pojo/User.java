package com.example.demo.pojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Integer userID;
    @Column(name = "username")
    private String userName;
    @Column(name = "displayname")
    private String displayName;
    @Column(name = "password")
    private String password;
    @Column(name = "birthdate")
    private Date birthDate;
    @Column(name = "emailaddress")
    private String emailAddress;
    @Column(name = "contactnumber")
    private String contactNumber;
    @Column(name = "gender")
    private boolean gender;
    @Column(name = "icnumber")
    private String icNumber;
    @Column(name = "usertype")
    private Integer userType;

    @Column(name = "dentalid")
    private Integer dentalID;

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIcNumber() {
        return icNumber;
    }

    public void setIcNumber(String icNumber) {
        this.icNumber = icNumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }


    public boolean isGender() {
        return gender;
    }

    public Integer getDentalID() {
        return dentalID;
    }

    public void setDentalID(Integer dentalID) {
        this.dentalID = dentalID;
    }

}
