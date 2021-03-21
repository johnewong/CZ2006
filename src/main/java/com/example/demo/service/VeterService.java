package com.example.demo.service;

import com.example.demo.dao.VeterDAO;
import com.example.demo.pojo.Vet;
import com.example.demo.pojo.Veter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VeterService {
    @Autowired
    VeterDAO veterDAO;

    public Veter getByVeterID(Integer dentaild){
        return veterDAO.findVeterByVeterIDAndIsDeletedFalse(dentaild);
    }

    public void addVeter(Veter veter,Vet vet){

        Date updatedDate = new Date();
        Veter veterModel = new Veter();
        veterModel.setVeterName(veter.getVeterName());
        veterModel.setVeterDescription(veter.getVeterDescription());
        veterModel.setVet(vet);
        veterModel.setGender(veter.getGender());
        veterModel.setCreatedDate(updatedDate);
        veterModel.setCreatedBy(vet.getCreatedBy());
        veterModel.setIsDeleted(false);

        veterDAO.save(veterModel);

    }

    public void edit(Veter veter) {
        Veter veterModel = veterDAO.findVeterByVeterIDAndIsDeletedFalse(veter.getVeterID());
        veterModel.setIsDeleted(veter.getIsDeleted());
        veterModel.setUpdatedBy(veter.getUpdatedBy());
        veterModel.setVeterDescription(veter.getVeterDescription());
        veterModel.setVeterName(veter.getVeterName());
        veterModel.setGender(veter.getGender());
        veterModel.setScheduleList(veter.getScheduleList());
        veterModel.setLeaveStartDate(veter.getLeaveStartDate());
        veterModel.setLeaveEndDate(veter.getLeaveEndDate());
        if (veter.getLeaveStartDate()!=null){
            veterModel.setOnLeave(true);
        }
        veterDAO.save(veterModel);
    }

    public List<Veter> getByVet(Vet vet){

        return veterDAO.findVeterByVetAndIsDeletedFalse(vet);
    }


}
