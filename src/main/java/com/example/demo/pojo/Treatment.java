package com.example.demo.pojo;

import javax.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "treatment")
@Where(clause = "isDeleted='false'")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatmentid")
    private Integer treatmentID;

    @Column(name = "treatmentname")
    private String treatmentName;

    @Column(name = "createdby")
    private Integer createdBy;

    @Column(name = "createddate")
    private Date createdDate;

    @Column(name = "updatedby")
    private Integer updatedBy;

    @Column(name = "updateddate")
    private Date updatedDate;

    @Column(name = "isdeleted")
    private boolean isDeleted;

    public Integer getTreatmentID() {
        return this.treatmentID;
    }

    public void setTreatmentID(Integer treatmentID) {
        this.treatmentID = treatmentID;
    }

    public String getTreatmentName() {
        return this.treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentName = treatmentName;
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

    public boolean getIsDeleted() {
        return this.isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
