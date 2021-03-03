package com.example.demo.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Dental;

public interface DentalDAO extends JpaRepository<Dental,Integer>{

    public Dental findByDentalID(Integer dentistID, Boolean isDeleted);

}