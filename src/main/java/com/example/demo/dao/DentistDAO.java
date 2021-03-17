package com.example.demo.dao;

import com.example.demo.pojo.Dental;
import com.example.demo.pojo.Dentist;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DentistDAO extends JpaRepository<Dentist,Integer> {
    Dental findByDentistIDAndIsDeletedFalse(Integer dentistID);
    List<Dental> findAllByIsDeletedFalse(Sort sort);

    Dentist findDentistByDentistIDAndIsDeletedFalse(Integer dentistID);

}
