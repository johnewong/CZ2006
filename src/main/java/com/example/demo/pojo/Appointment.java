package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "appointment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Appointment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentid")
    private Integer appointmentID;

    @Column(name = "appointmentnumber")
    private String appointmentNumber;

    @Column(name = "appointmentdate")
    private Timestamp appointmentDate;

    @Column(name = "appointmentstarttime")
    private Timestamp appointmentStartTime;

    @Column(name = "appointmentendtime")
    private Timestamp appointmentEndTime;

    @Column(name = "customerid")
    private Integer customerID;

    @Column(name = "customername")
    private String customerName;

    @Column(name = "status")
    private Integer status;

    @Column(name = "veterid")
    private Integer veterID;

    @Column(name = "vetid")
    private Integer vetID;

    @Column(name = "treatmentid")
    private Integer treatmentID;

    public Integer getAppointmentID() {
        return this.appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentNumber() {
        return this.appointmentNumber;
    }

    public void setAppointmentNumber(String appointmentNumber) {
        this.appointmentNumber = appointmentNumber;
    }

    public Timestamp getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(Timestamp appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Timestamp getAppointmentStartTime() {
        return this.appointmentStartTime;
    }

    public void setAppointmentStartTime(Timestamp appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public Timestamp getAppointmentEndTime() {
        return this.appointmentEndTime;
    }

    public void setAppointmentEndTime(Timestamp appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public Integer getCustomerID() {
        return this.customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getVeterID() {
        return this.veterID;
    }

    public void setVeterID(Integer veterID) {
        this.veterID = veterID;
    }

    public Integer getVetID() {
        return this.vetID;
    }

    public void setVetID(Integer vetID) {
        this.vetID = vetID;
    }

    public Integer getTreatmentID() {
        return this.treatmentID;
    }

    public void setTreatmentID(Integer treatmentID) {
        this.treatmentID = treatmentID;
    }
}
