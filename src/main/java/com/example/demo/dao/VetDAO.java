package com.example.demo.dao;
import com.example.demo.pojo.Vet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VetDAO extends JpaRepository<Vet,Integer>{

    Vet findByVetIDAndIsDeletedFalse(Integer veterID);
    List<Vet> findAllByIsDeletedFalse(Sort sort);
    List<Vet> findByLocationIDAndIsDeletedFalse(Integer locationid);

}