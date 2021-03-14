package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dental_treatment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class DentalTreatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dental_treatmentid")
    private Integer dental_TreatmentID;

    //@Column(name = "dentalid")
    //private Integer dentalID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentalid")
    private Dental dental;


    @Column(name = "treatmentid")
    private Integer treatmentID;

    @Column(name = "persessionduration")
    private float perSeccionDuration;

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

    public Integer getDental_TreatmentID() {
        return dental_TreatmentID;
    }

    public void setDental_TreatmentID(Integer dental_TreatmentID) {
        this.dental_TreatmentID = dental_TreatmentID;
    }

    //public Integer getDentalID() {
   //     return dentalID;
    //}

   // public void setDentalID(Integer dentalID) {
   //     this.dentalID = dentalID;
    //}

    public Integer getTreatmentID() {
        return treatmentID;
    }

    public void setTreatmentID(Integer treatmentID) {
        this.treatmentID = treatmentID;
    }

    public float getPerSeccionDuration() {
        return perSeccionDuration;
    }

    public void setPerSeccionDuration(float perSeccionDuration) {
        this.perSeccionDuration = perSeccionDuration;
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

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    @JsonBackReference
    public void setDental(Dental dental) {
        this.dental = dental;
    }


}
