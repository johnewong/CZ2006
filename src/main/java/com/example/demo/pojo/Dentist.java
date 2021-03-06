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

    @Column(name = "dentistname")
    private String DentistName;

    @Column(name = "dentalid")
    private Integer DentalID;

    @Column(name = "dentistdescription")
    private String DentistDescription;

    @Column(name = "gender")
    private String Gender;

    @Column(name = "isonleave")
    private boolean IsOnLeave ;









}
