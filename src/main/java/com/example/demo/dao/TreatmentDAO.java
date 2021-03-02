package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Treatment;

public interface TreatmentDAO extends JpaRepository<Treatment,Integer>{

    public Treatment findByTreatmentID(Integer treatmentID);
}