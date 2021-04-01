package com.example.demo.dao;
import com.example.demo.pojo.Vet;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VetDAO extends JpaRepository<Vet,Integer>{

    Vet findByVetIDAndIsDeletedFalse(Integer veterID);
    List<Vet> findAllByIsDeletedFalse(Sort sort);
    List<Vet> findByLocationIDAndIsDeletedFalse(Integer locationid);

    @Query("select v.locationID from Vet v where v.isDeleted=false group by v.locationID order by v.locationID asc")
    List<Integer> findGroupByLocationID();

}