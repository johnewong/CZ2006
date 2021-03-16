package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dental_treatment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class DentalTreatment extends BaseEntity {

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

    @JsonBackReference
    public void setDental(Dental dental) {
        this.dental = dental;
    }

}
