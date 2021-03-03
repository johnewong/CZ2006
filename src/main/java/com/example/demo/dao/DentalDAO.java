package com.example.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Dental;

public interface DentalDAO extends JpaRepository<Dental,Integer>{

    Dental findByDentalID(Integer dentistID);

}