package com.example.demo.controller;

import com.example.demo.pojo.Vet;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.LocationData;
import com.example.demo.service.VetService;
import com.example.demo.viewmodel.LoginInfo;
import com.example.demo.viewmodel.VetLocationRegister;
import com.example.demo.viewmodel.VeterSlot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Api(tags = "Vet management")
@RestController
@RequestMapping(value = "vet")
public class VetController {
    @Autowired
    VetService vetService;
    AppointmentService appointmentService;

    @ApiOperation(value = "api to get a vet by vetid", notes = "", response = Vet.class)
    @GetMapping("/{vetid}")
    /**
     * This method gets a vet information by vet ID.
     * @param vetid veter ID.
     * @return vet information.
     */
    public Vet getByID(@PathVariable("vetid") Integer vetid) throws Exception {
        Vet vet = vetService.getByVetID(vetid);
        return vet;
    }

    @ApiOperation(value = "api to get all vet")
    @GetMapping("/list")
    /**
     * This method gets all Vet.
     * @return vet list.
     */
    public List<Vet> getAll() throws Exception {
        List<Vet> vets = vetService.list();
        return vets;
    }

    @ApiOperation(value = "api to get all locations")
    @GetMapping("/locations")
    /**
     * This method gets all locations.
     * @return int list.
     */
    public List<LocationData> getAllLocation(){
       return vetService.getAllLocation();
    }

    @ApiOperation(value = "api to get public data")
    @GetMapping("/publicData")
    /**
     * This method gets a public data from gov api
     */
    public List<Vet> getPublicData() throws Exception {
        final String uri = "https://data.gov.sg/api/action/datastore_search?resource_id=b2871270-4eef-44a3-be98-908e2a73b19f";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);

        return vetService.dataProcess(result);
    }

    @ApiOperation(value = "api to register vet location  \"Coordinate\": \"lat:40, lng:2\" ")
    @PostMapping("/registerLocation")
    /**
     * This method register vet location
     * @param  List<VetLocationRegister> info.
     */
    public List<Vet> registerLocation(@RequestBody List<VetLocationRegister> info) throws Exception {
        return vetService.updateVetLocation(info);
    }


}
