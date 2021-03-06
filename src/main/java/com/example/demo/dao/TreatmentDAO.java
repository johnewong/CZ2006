package com.example.demo.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Treatment;

import java.util.List;

public interface TreatmentDAO extends JpaRepository<Treatment,Integer>{

    List<Treatment> findAllByIsDeletedFalse(Sort sort);

    Treatment findByTreatmentIDAndIsDeletedFalse(Integer treatmentID);


}