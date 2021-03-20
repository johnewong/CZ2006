package com.example.demo.service;

import com.example.demo.dao.DentalDAO;
import com.example.demo.dao.DentistDAO;
import com.example.demo.pojo.Dental;
import com.example.demo.pojo.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DentistService {
    @Autowired
    DentistDAO dentistDAO;

    public Dentist getDentistInfobyDentistID(Integer dentaild){
        return dentistDAO.findDentistByDentistIDAndIsDeletedFalse(dentaild);
    }

    public void addDentist(Dentist dentist,Dental dental){

        Date updatedDate = new Date();
        Dentist dentistModel = new Dentist();
        dentistModel.setDentistName(dentist.getDentistName());
        dentistModel.setDentistDescription(dentist.getDentistDescription());
        dentistModel.setDental(dental);
        dentistModel.setGender(dentist.getGender());
        dentistModel.setCreatedDate(updatedDate);
        dentistModel.setCreatedBy(dental.getCreatedBy());
        dentistModel.setIsDeleted(false);

        dentistDAO.save(dentistModel);

    }

    public void edit(Dentist dentist) {
        Dentist dentistModel = dentistDAO.findDentistByDentistIDAndIsDeletedFalse(dentist.getDentistID());
        dentistModel.setIsDeleted(dentist.getIsDeleted());
        dentistModel.setUpdatedBy(dentist.getUpdatedBy());
        dentistModel.setDentistDescription(dentist.getDentistDescription());
        dentistModel.setDentistName(dentist.getDentistName());
        dentistModel.setGender(dentist.getGender());
        dentistModel.setScheduleList(dentist.getScheduleList());
        dentistModel.setLeaveStartDate(dentist.getLeaveStartDate());
        dentistModel.setLeaveEndDate(dentist.getLeaveEndDate());
        if (dentist.getLeaveStartDate()!=null){
            dentistModel.setOnLeave(true);
        }
        dentistDAO.save(dentistModel);
    }
}
