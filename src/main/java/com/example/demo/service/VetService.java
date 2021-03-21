package com.example.demo.service;

import com.example.demo.dao.VetDAO;
import com.example.demo.pojo.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VetService {
    @Autowired
    VetDAO vetDAO;

    public List<Vet> listall() {

        return vetDAO.findAll(Sort.by(Sort.Direction.ASC, "vetName"));
    }

    public List<Vet> list() {

        return vetDAO.findAllByIsDeletedFalse(Sort.by(Sort.Direction.ASC, "vetName"));
    }

    public Vet getByVetID(Integer vetid) {

        return vetDAO.findByVetIDAndIsDeletedFalse(vetid);
    }

    public void editVetProfile(Vet vet){

        Date updatedDate = new Date();

        Vet vetModel = this.getByVetID(vet.getVetId());
        vetModel.setVetAddress(vet.getVetAddress());
        vetModel.setVetName(vet.getVetName());
        vetModel.setVetDescription(vet.getVetDescription());
        vetModel.setOperatingHourStart(vet.getOperatingHourStart());
        vetModel.setOperatingHourEnd(vet.getOperatingHourEnd());
        vetModel.setUpdatedBy(vet.getUpdatedBy());
        vetModel.setUpdatedDate(updatedDate);

        vetDAO.save(vetModel);
    }


}
