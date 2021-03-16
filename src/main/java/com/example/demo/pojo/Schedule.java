package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dentist_working_schedule")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentistworkingscheduleid")
    private Integer scheduleID;

   // @Column(name = "dentistid")
   // private Integer dentistID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentistid")
    private Dentist dentist;


    @Column(name = "dayofweek")
    private Integer dayOfWeek;

    @Column(name = "starttime")
    private Date startTime;

    @Column(name = "endtime")
    private Date endTime;

    @Column(name = "breakstarttime")
    private Date breakStartTime;

    public Integer getScheduleID() {
        return this.scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

   // public Integer getDentistID() {
   //     return this.dentistID;
   // }

  //  public void setDentistID(Integer dentistID) {
  //      this.dentistID = dentistID;
  //  }

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

    @JsonBackReference
    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
