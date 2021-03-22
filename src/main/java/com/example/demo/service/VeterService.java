package com.example.demo.service;

import com.example.demo.dao.ScheduleDAO;
import com.example.demo.dao.VeterDAO;
import com.example.demo.pojo.Schedule;
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
    @Autowired
    ScheduleDAO scheduleDAO;
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
        veterModel.setUpdatedDate(updatedDate);
        veterModel.setUpdatedBy(vet.getUpdatedBy());
        veterModel.setIsDeleted(false);

        veterDAO.save(veterModel);

    }

    public boolean edit(Veter veter) {
        Veter veterModel = veterDAO.findVeterByVeterIDAndIsDeletedFalse(veter.getVeterID());
        if(veterModel == null){
            return false;
        }
        veterModel.setUpdatedBy(veter.getUpdatedBy());
        veterModel.setVeterDescription(veter.getVeterDescription());
        veterModel.setVeterName(veter.getVeterName());
        veterModel.setGender(veter.getGender());
        veterModel.setLeaveStartDate(veter.getLeaveStartDate());
        veterModel.setLeaveEndDate(veter.getLeaveEndDate());


       // veterModel.setScheduleList(veter.getScheduleList());
        if (veter.getLeaveStartDate()!=null){
            veterModel.setOnLeave(true);
        }
        veterDAO.save(veterModel);


         for(Schedule sitem : veterModel.getScheduleList()){
             sitem.setIsDeleted(true);
             scheduleDAO.save(sitem);
         }

        for(Schedule sitem : veter.getScheduleList()){
            sitem.setVeter(veterModel);
            scheduleDAO.save(sitem);
        }


        return true;
    }

    public List<Veter> getByVet(Vet vet){

        return veterDAO.findVeterByVetAndIsDeletedFalse(vet);
    }


}
