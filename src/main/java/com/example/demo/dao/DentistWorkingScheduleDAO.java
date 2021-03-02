package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.pojo.DentistWorkingSchedule;

public interface DentistWorkingScheduleDAO extends JpaRepository<DentistWorkingSchedule,Integer>{

    public DentistWorkingSchedule findByDentistID(Integer dentistID);
}