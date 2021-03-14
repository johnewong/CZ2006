package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "dental")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentalid")
    private Integer dentalID;

    @Column(name = "dentalname")
    private String dentalName;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "dental", fetch = FetchType.EAGER)
    private Set<Dentist> dentistList;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "dental", fetch = FetchType.EAGER)
    private Set<DentalTreatment> dentalTreatmentList;

    @Column(name = "dentaldescription")
    private String dentalDescription;

    @Column(name = "dentaladdress")
    private String dentalAddress;

    @Column(name = "operatinghourstart")
    private Date operatingHourStart;

    @Column(name = "operatinghourend")
    private Date operatingHourEnd;

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

    public Integer getDentalId() {
        return this.dentalID;
    }

    public void setDentalId(Integer dentalID) {
        this.dentalID = dentalID;
    }

    public String getDentalName() {
        return this.dentalName;
    }

    public void setDentalName(String dentalName) {
        this.dentalName = dentalName;
    }

    public String getDentalDescription() {
        return this.dentalDescription;
    }

    public void setDentalDescription(String dentalDescription) {
        this.dentalDescription = dentalDescription;
    }

    public String getDentalAddress() {
        return this.dentalAddress;
    }

    public void setDentalAddress(String dentalAddress) {
        this.dentalAddress = dentalAddress;
    }

    public Date getOperatingHourStart() {
        return this.operatingHourStart;
    }

    public void setOperatingHourStart(Date operatingHourStart) {
        this.operatingHourStart = operatingHourStart;
    }

    public Date getOperatingHourEnd() {
        return this.operatingHourEnd;
    }

    public void setOperatingHourEnd(Date operatingHourEnd) {
        this.operatingHourEnd = operatingHourEnd;
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

    public Set<Dentist> getDentistList() {
        return dentistList;
    }

    public void setDentistList(Set<Dentist> dentistList) {
        this.dentistList = dentistList;
    }

    public Set<DentalTreatment> getDentalTreatmentList() {
        return dentalTreatmentList;
    }

    public void setDentalTreatmentList(Set<DentalTreatment> dentalTreatmentList) {
        this.dentalTreatmentList = dentalTreatmentList;
    }
}
