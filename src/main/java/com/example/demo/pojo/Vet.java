package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "vet")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Vet extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vetid")
    private Integer vetID;

    @Column(name = "vetname")
    private String vetName;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "vet", fetch = FetchType.EAGER)
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

//    public List<Treatment> getTreatmentList() {
//        return treatmentList;
//    }
//
//    public void setTreatmentList(List<Treatment> treatmentList) {
//        this.treatmentList = treatmentList;
//    }
}
