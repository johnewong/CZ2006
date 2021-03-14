package com.example.demo.dao;

import com.example.demo.pojo.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleDAO extends JpaRepository<Schedule,Integer>{

 /* List<Schedule> findByDentistIDAndIsDeletedFalse(Integer dentistID);*/
}