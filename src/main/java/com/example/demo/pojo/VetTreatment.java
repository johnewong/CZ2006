package com.example.demo.pojo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "vet_treatment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class VetTreatment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vet_treatmentid")
    private Integer vet_TreatmentID;

    //@Column(name = "vetid")
    //private Integer vetID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vetid")
    private Vet vet;


    @Column(name = "treatmentid")
    private Integer treatmentID;

    @Column(name = "persessionduration")
    private float perSeccionDuration;

    public Integer getVet_TreatmentID() {
        return vet_TreatmentID;
    }

    public void setVet_TreatmentID(Integer vet_TreatmentID) {
        this.vet_TreatmentID = vet_TreatmentID;
    }

    //public Integer getVetID() {
   //     return vetID;
    //}

   // public void setVetID(Integer vetID) {
   //     this.vetID = vetID;
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
    public void setVet(Vet vet) {
        this.vet = vet;
    }

}
