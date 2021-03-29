package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vet")
@JsonIgnoreProperties({"handler", "hibernateLazyInitializer"})
public class Vet extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vetid")
    private Integer vetID;

    @Column(name = "vetname")
    private String vetName;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "vet", fetch = FetchType.EAGER)
    @OrderBy("veterName ASC")
    private Set<Veter> veterList;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "vet", fetch = FetchType.EAGER)
    private Set<VetTreatment> vetTreatmentList;

//    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
//    private List<Treatment> treatmentList;

    @Column(name = "vetdescription")
    private String vetDescription;

    @Column(name = "vetaddress")
    private String vetAddress;

    @Column(name = "operatinghourstart")
    private Date operatingHourStart;

    @Column(name = "operatinghourend")
    private Date operatingHourEnd;

    @Column(name = "postal_code")
    private String postal_code;

    @Column(name = "locationID")
    private int locationID;

    @Column(name = "tel_office_1")
    private String tel_office_1;

    @Column(name = "tel_office_2")
    private String tel_office_2;

    public Integer getVetId() {
        return this.vetID;
    }

    public void setVetId(Integer vetID) {
        this.vetID = vetID;
    }

    public String getVetName() {
        return this.vetName;
    }

    public void setVetName(String vetName) {
        this.vetName = vetName;
    }

    public String getVetDescription() {
        return this.vetDescription;
    }

    public void setVetDescription(String vetDescription) {
        this.vetDescription = vetDescription;
    }

    public String getVetAddress() {
        return this.vetAddress;
    }

    public void setVetAddress(String vetAddress) {
        this.vetAddress = vetAddress;
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

    public Set<VetTreatment> getVetTreatmentList() {
        return this.vetTreatmentList;
    }

    public void setVetTreatmentList(Set<VetTreatment> treatmentList) {
        this.vetTreatmentList = treatmentList;
    }

    public Set<Veter> getVeterList() {
        return veterList;
    }

    public void setVeterList(Set<Veter> veterList) {
        this.veterList = veterList;
    }

    public String getTel_office_1() {
        return tel_office_1;
    }

    public void setTel_office_1(String tel_office_1) {
        this.tel_office_1 = tel_office_1;
    }

    public String getTel_office_2() {
        return tel_office_2;
    }

    public void setTel_office_2(String tel_office_2) {
        this.tel_office_2 = tel_office_2;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public int getLocationID() {
        return locationID;
    }

    public void setLocationID(int locationID) {
        this.locationID = locationID;
    }
//    public List<Treatment> getTreatmentList() {
//        return treatmentList;
//    }
//
//    public void setTreatmentList(List<Treatment> treatmentList) {
//        this.treatmentList = treatmentList;
//    }
}
