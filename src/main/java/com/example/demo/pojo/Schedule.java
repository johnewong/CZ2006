package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "veter_working_schedule")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterworkingscheduleid")
    private Integer scheduleID;

   // @Column(name = "veterid")
  // private Integer veterID ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veterid")
    private Veter veter;


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

    public Integer getScheduleID() {
        return this.scheduleID;
    }

    public void setScheduleID(Integer scheduleID) {
        this.scheduleID = scheduleID;
    }

   // public Integer getVeterID() {
   //     return this.veterID;
   // }

  //  public void setVeterID(Integer veterID) {
  //      this.veterID = veterID;
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
    public Date getBreakEndTime() {
        return this.breakEndTime;
    }

    public void setBreakEndTime(Date breakEndTime) {
        this.breakEndTime = breakEndTime;
    }

    public Veter getVeter() { return veter; }

    @JsonBackReference
    public void setVeter(Veter veter) {
        this.veter = veter;
    }


}
