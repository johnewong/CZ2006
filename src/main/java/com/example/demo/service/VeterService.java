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

    public void addVeter(Veter veter, Vet vet){

        Date updatedDate = new Date();
        Veter veterModel = new Veter();
        veterModel.setVeterName(veter.getVeterName());
        veterModel.setVeterDescription(veter.getVeterDescription());
        veterModel.setVet(vet);
        veterModel.setGender(veter.getGender());
        veterModel.setCreatedDate(updatedDate);
        veterModel.setCreatedBy(0);
        veterModel.setIsDeleted(false);

        veterDAO.save(veterModel);

    }
    public void editVetProfile(Veter veter){
    }


    public List<Veter> getByVet(Vet vet){

        return veterDAO.findVeterByVetAndIsDeletedFalse(vet);
    }


}
