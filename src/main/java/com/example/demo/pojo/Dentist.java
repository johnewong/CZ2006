package com.example.demo.pojo;

import javax.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "dentist")
@Where(clause = "isDeleted='false'")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentistid")
    private Integer dentistID;

    @Column(name = "dentistname")
    private String dentistName;

    @Column(name = "dentalid")
    private Integer dentalID;

    @Column(name = "dentistdescription")
    private String dentistDescription;

    @Column(name = "gender")
    private String gender;

    @Column(name = "isonleave")
    private boolean isOnLeave;

    @Column(name = "leavestartdate")
    private Date leaveStartDate;

    @Column(name = "leaveenddate")
    private Date leaveEndDate;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "updatedby")
    private Integer updatedBy;

    @Column(name = "updateddate")
    private Date updatedDate;

    @Column(name = "isdeleted")
    private boolean isDelected;

    public Integer getDentistID() {
        return dentistID;
    }

    public void setDentistID(Integer dentistID) {
        this.dentistID = dentistID;
    }

    public String getDentistName() {
        return dentistName;
    }

    public void setDentistName(String dentistName) {
        this.dentistName = dentistName;
    }

    public Integer getDentalID() {
        return dentalID;
    }

    public void setDentalID(Integer dentalID) {
        this.dentalID = dentalID;
    }

    public String getDentistDescription() {
        return dentistDescription;
    }

    public void setDentistDescription(String dentistDescription) {
        this.dentistDescription = dentistDescription;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isOnLeave() {
        return isOnLeave;
    }

    public void setOnLeave(boolean onLeave) {
        isOnLeave = onLeave;
    }

    public Date getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(Date leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public Date getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(Date leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isDelected() {
        return isDelected;
    }

    public void setDelected(boolean delected) {
        isDelected = delected;
    }
}
