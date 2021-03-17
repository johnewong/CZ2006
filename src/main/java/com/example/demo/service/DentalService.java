package com.example.demo.service;

import com.example.demo.dao.DentalDAO;
import com.example.demo.pojo.Dental;
import com.example.demo.pojo.Dentist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DentalService {
    @Autowired DentalDAO dentalDAO;

    public List<Dental> listall() {

        return dentalDAO.findAll(Sort.by(Sort.Direction.ASC, "dentalName"));
    }

    public List<Dental> list() {

        return dentalDAO.findAllByIsDeletedFalse(Sort.by(Sort.Direction.ASC, "dentalName"));
    }

    public Dental getByDentalID(Integer dentalid) {

        return dentalDAO.findByDentalIDAndIsDeletedFalse(dentalid);
    }

    public void editDentalProfile(Dental dental){

        Date updatedDate = new Date();

        Dental dentalModel = this.getByDentalID(dental.getDentalId());
        dentalModel.setDentalAddress(dental.getDentalAddress());
        dentalModel.setDentalName(dental.getDentalName());
        dentalModel.setDentalDescription(dental.getDentalDescription());
        dentalModel.setOperatingHourStart(dental.getOperatingHourStart());
        dentalModel.setOperatingHourEnd(dental.getOperatingHourEnd());
        dentalModel.setUpdatedBy(dental.getUpdatedBy());
        dentalModel.setUpdatedDate(updatedDate);

        dentalDAO.save(dentalModel);
    }


}
