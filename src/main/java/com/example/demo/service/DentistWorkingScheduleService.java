package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.pojo.DentistWorkingSchedule;
import com.example.demo.dao.DentistWorkingScheduleDAO;

@Service
public class DentistWorkingScheduleService {

    @Autowired
    DentistWorkingScheduleDAO dentistWorkingScheduleDAO;


    public List<DentistWorkingSchedule> getByDentistID(Integer dentistid) {
        return dentistWorkingScheduleDAO.findByDentistID(dentistid);
    }
}
