package com.example.demo.dao;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Dental;

import java.util.List;

public interface DentalDAO extends JpaRepository<Dental,Integer>{

    Dental findByDentalIDAndIsDeletedFalse(Integer dentistID);

    List<Dental> findAllByIsDeletedFalse(Sort sort);

}