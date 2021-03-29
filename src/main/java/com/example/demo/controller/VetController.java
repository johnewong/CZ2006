package com.example.demo.controller;

import com.example.demo.pojo.Vet;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.VetService;
import com.example.demo.viewmodel.VeterSlot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        List<Vet> vets= vetService.list();
        return vets;
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


}
