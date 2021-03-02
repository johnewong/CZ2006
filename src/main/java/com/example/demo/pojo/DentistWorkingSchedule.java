package com.example.demo.pojo;

import javax.persistence.*;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dentist_working_schedule")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class DentistWorkingSchedule {
    @Id
    @Column(name = "dentistworkingscheduleid")
    private Integer dentistWorkingScheduleID;

    @Column(name = "dentistid")
    private Integer dentistID;

    @Column(name = "dayofweek")
    private Integer dayOfWeek;

    @Column(name = "starttime")
    private Date startTime;

    @Column(name = "endtime")
    private Date endTime;

    @Column(name = "breakstarttime")
    private Date breakStartTime;

    @Column(name = "breakendtime")
    private Date breakEndTime;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "updatedby")
    private Integer updatedBy;

    @Column(name = "updateddate")
    private Date updatedDate;

    @Column(name = "isdeleted")
    private Boolean isDeleted;

    public Integer getDentistWorkingScheduleID() {
        return this.dentistWorkingScheduleID;
    }

    public void setDentistWorkingScheduleID(Integer dentistWorkingScheduleID) {
        this.dentistWorkingScheduleID = dentistWorkingScheduleID;
    }

    public Integer getDentistID() {
        return this.dentistID;
    }

    public void setDentistID(Integer dentistID) {
        this.dentistID = dentistID;
    }

    public Integer getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBreakStartTime() {
        return this.breakStartTime;
    }

    public void setBreakStartTime(Date breakStartTime) {
        this.breakStartTime = breakStartTime;
    }

    public Date getBreakEndTime() {
        return this.breakEndTime;
    }

    public void setBreakEndTime(Date breakEndTime) {
        this.breakEndTime = breakEndTime;
    }

    public Integer getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
