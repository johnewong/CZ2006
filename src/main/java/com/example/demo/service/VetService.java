package com.example.demo.service;

import com.example.demo.dao.VetDAO;
import com.example.demo.pojo.Vet;
import com.example.demo.utility.LocationMapper;
import com.example.demo.viewmodel.VetLocationRegister;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class VetService {
    @Autowired
    VetDAO vetDAO;

    /**
     * Method to get all vets
     *
     * @return list of vets
     */
    public List<Vet> listall() {

        return vetDAO.findAll(Sort.by(Sort.Direction.ASC, "vetName"));
    }

    /**
     * Method to get all undeleted vets
     *
     * @return list of undeleted vets
     */
    public List<Vet> list() {

        return vetDAO.findAllByIsDeletedFalse(Sort.by(Sort.Direction.ASC, "vetName"));
    }

    /**
     * Method to get vet by betid
     *
     * @param vetid
     * @return vet
     */
    public Vet getByVetID(Integer vetid) {

        return vetDAO.findByVetIDAndIsDeletedFalse(vetid);
    }

    /**
     * Method to edit vet profile
     *
     * @param vet
     */
    public void editVetProfile(Vet vet) {

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

    public List<Vet> dataProcess(String json) throws JsonProcessingException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        var startTime = new SimpleDateFormat("hh:mm:ss").parse("09:00:00");
        var endTime = new SimpleDateFormat("hh:mm:ss").parse("18:30:00");

        PublicData data = objectMapper.readValue(json, PublicData.class);
        var records = data.result.records;

        var newVets = new ArrayList<Vet>();
        for (Record record : records) {
            Vet newVet = new Vet();
            newVet.setVetName(record.name);
            newVet.setVetAddress(record.address);
            newVet.setOperatingHourStart(startTime);
            newVet.setOperatingHourEnd(endTime);
            newVet.setPostal_code(record.postal_code);
            newVet.setTel_office_1(record.tel_office_1);
            newVet.setTel_office_2(record.tel_office_2);
            newVets.add(newVet);
        }
        vetDAO.saveAll(newVets);

        return newVets;
    }

    public List<Vet> getByLocationID(Integer locationid) {
        return vetDAO.findByLocationIDAndIsDeletedFalse(locationid);
    }

    public List<LocationData> getAllLocation() {
        var locationIDs=vetDAO.findGroupByLocationID();
        var locations = new ArrayList<LocationData>();

        for(int locationID : locationIDs){
           var location = new LocationData();
           location.LocationID=locationID;
           location.Name =  LocationMapper.getValue(locationID);
           locations.add(location);
        }

        return locations;
    }

    public List<Vet> updateVetLocation(List<VetLocationRegister> info) {
        var allVets = vetDAO.findAll();
        var updateVets = new ArrayList<Vet>();

        for (VetLocationRegister vet : info) {
            var matchVet = allVets.stream().filter(v -> v.getVetId() == vet.VetID).findAny().get();
            matchVet.setLocationID(vet.LocationID);
            matchVet.setCoordinate(vet.Coordinate);
            updateVets.add(matchVet);
        }
        vetDAO.saveAll(updateVets);

        return updateVets;
    }
}
