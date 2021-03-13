package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.Schedule;

public interface ScheduleDAO extends JpaRepository<Schedule,Integer>{

  List<Schedule> findByDentistIDAndIsDeletedFalse(Integer dentistID);
}