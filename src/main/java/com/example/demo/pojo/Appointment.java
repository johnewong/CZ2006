package com.example.demo.pojo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Appointment {
    @Id
    @Column(name = "appointmentid")
    private Integer appointmentID;

    @Column(name = "appointmentnumber")
    private String appointmentNumber;

    @Column(name = "appointmentdate")
    private Date appointmentDate;

    @Column(name = "appointmentstarttime")
    private Date appointmentStartTime;

    @Column(name = "appointmentendtime")
    private Date appointmentEndTime;

    @Column(name = "patientid")
    private Integer patientID;

    @Column(name = "patientname")
    private String patientName;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "dentistid")
    private Integer dentistID;

    @Column(name = "dentalid")
    private Integer dentalID;

    @Column(name = "treatmentid")
    private Integer treatmentID;

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

    public Date getAppointmentDate() {
        return this.appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getAppointmentStartTime() {
        return this.appointmentStartTime;
    }

    public void setAppointmentStartTime(Date appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public Date getAppointmentEndTime() {
        return this.appointmentEndTime;
    }

    public void setAppointmentEndTime(Date appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public Integer getPatientID() {
        return this.patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getPatientName() {
        return this.patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getDentistID() {
        return this.dentistID;
    }

    public void setDentistID(Integer dentistID) {
        this.dentistID = dentistID;
    }

    public Integer getDentalID() {
        return this.dentalID;
    }

    public void setDentalID(Integer dentalID) {
        this.dentalID = dentalID;
    }

    public Integer getTreatmentID() {
        return this.treatmentID;
    }

    public void setTreatmentID(Integer treatmentID) {
        this.treatmentID = treatmentID;
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
