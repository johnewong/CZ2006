package com.example.demo.service;

import com.example.demo.dao.DentalDAO;
import com.example.demo.pojo.Dental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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

    public Dental getByID(Integer dentalid) {

        return dentalDAO.findByDentalIDAndIsDeletedFalse(dentalid);
    }

    public void edit(Dental dental){

        dentalDAO.save(dental);
    }

}
