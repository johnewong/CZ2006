package com.example.demo.dao;

import com.example.demo.pojo.Vet;
import com.example.demo.pojo.Veter;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VeterDAO extends JpaRepository<Veter,Integer> {
    Veter findByVeterIDAndIsDeletedFalse(Integer veterID);
    List<Veter> findAllByIsDeletedFalse(Sort sort);

    Veter findVeterByVeterIDAndIsDeletedFalse(Integer veterID);
    List<Veter> findVeterByVetAndIsDeletedFalse(Vet vet);
}
