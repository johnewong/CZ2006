package com.example.demo.service;

import com.example.demo.dao.DentistDAO;
import com.example.demo.pojo.Dental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DentistService {
    @Autowired
    DentistDAO dentistDAO;

    public Dental getByDentistID(Integer dentalid) {

        return dentistDAO.findByDentistIDAndIsDeletedFalse(dentalid);
    }



}
