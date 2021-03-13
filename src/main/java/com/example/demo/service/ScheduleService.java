package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.Schedule;
import com.example.demo.dao.ScheduleDAO;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;


    public List<Schedule> getByDentistID(Integer dentistid) {
        return scheduleDAO.findByDentistIDAndIsDeletedFalse(dentistid);
    }
}
