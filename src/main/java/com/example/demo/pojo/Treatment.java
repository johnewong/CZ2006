package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "treatment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Treatment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "treatmentid")
    private Integer treatmentID;

    @Column(name = "treatmentname")
    private String treatmentName;

    @ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Dental> dentalList;

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

    public List<Dental> getDentalList() {
        return dentalList;
    }

    public void setDentalList(List<Dental> dentalList) {
        this.dentalList = dentalList;
    }

}
