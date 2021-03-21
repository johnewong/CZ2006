package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "veter")
@Where(clause = "isDeleted='false'")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})

public class Veter extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "veterid")
    private Integer veterID;

    @Column(name = "vetername")
    private String veterName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vetid")
    private Vet vet;

//    @Column(name = "vetid")
//    private Integer vetID;


    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "veter", fetch = FetchType.EAGER)
    private Set<Schedule> scheduleList;


    @Column(name = "veterdescription")
    private String veterDescription;

    @Column(name = "gender")
    private String gender;

    @Column(name = "isonleave")
    private boolean isOnLeave;

    @Column(name = "leavestartdate")
    private Date leaveStartDate;

    @Column(name = "leaveenddate")
    private Date leaveEndDate;


    @Column(name = "isdeleted")
    private boolean isDeleted;


    public Integer getVeterID() {
        return veterID;
    }

    public void setVeterID(Integer veterID) {
        this.veterID = veterID;
    }

    public String getVeterName() {
        return veterName;
    }

    public void setVeterName(String veterName) {
        this.veterName = veterName;
    }
//
//    public Integer getVetID() {
//        return vetID;
//    }
//
//    public void setVetID(Integer vetID) {
//        this.vetID = vetID;
//    }

    public String getVeterDescription() {
        return veterDescription;
    }

    public void setVeterDescription(String veterDescription) {
        this.veterDescription = veterDescription;
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

    public Vet getVet() {
        return vet;
    }


    public Set<Schedule> getScheduleList() {
        return scheduleList;
    }

    public void setScheduleList(Set<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @JsonBackReference
    public void setVet(Vet vet) {
        this.vet = vet;
    }

}
