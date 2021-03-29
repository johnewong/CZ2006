package com.example.demo.controller;

import com.example.demo.pojo.Appointment;
import com.example.demo.pojo.Vet;
import com.example.demo.service.AppointmentService;
import com.example.demo.service.VetService;
import com.example.demo.viewmodel.VeterSlot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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




}
