package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.DentistWorkingSchedule;

public interface DentistWorkingScheduleDAO extends JpaRepository<DentistWorkingSchedule,Integer>{

  List<DentistWorkingSchedule> findByDentistID(Integer dentistID);
}