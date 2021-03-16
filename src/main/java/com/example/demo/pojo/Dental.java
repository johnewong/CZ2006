package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "dental")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Dental extends BaseEntity{
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

//    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<Treatment> treatmentList;

    @Column(name = "dentaldescription")
    private String dentalDescription;

    @Column(name = "dentaladdress")
    private String dentalAddress;

    @Column(name = "operatinghourstart")
    private Date operatingHourStart;

    @Column(name = "operatinghourend")
    private Date operatingHourEnd;

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

    public Set<DentalTreatment> getDentalTreatmentList() {
        return this.dentalTreatmentList;
    }

    public void setDentalTreatmentList(Set<DentalTreatment> treatmentList) {
        this.dentalTreatmentList = treatmentList;
    }

    public Set<Dentist> getDentistList() {
        return dentistList;
    }

    public void setDentistList(Set<Dentist> dentistList) {
        this.dentistList = dentistList;
    }

//    public List<Treatment> getTreatmentList() {
//        return treatmentList;
//    }
//
//    public void setTreatmentList(List<Treatment> treatmentList) {
//        this.treatmentList = treatmentList;
//    }
}
