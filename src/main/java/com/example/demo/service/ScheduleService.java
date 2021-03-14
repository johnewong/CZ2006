package com.example.demo.service;

import com.example.demo.dao.ScheduleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;

/*
    public List<Schedule> getByDentistID(Integer dentistid) {
        return scheduleDAO.findByDentistIDAndIsDeletedFalse(dentistid);
    }*/
}
