package com.example.demo.pojo;

import javax.persistence.*;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "dentist")
@Where(clause = "isDeleted='false'")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })

public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dentistid")
    private Integer DentistID;

    @Column(name = "DentistName")
    private String DentistName;

    @Column(name = "DentalID")
    private Integer DentalID;

    @Column(name = "DentistDescription")
    private String DentistDescription;

    @Column(name = "Gender")
    private String Gender;









}
