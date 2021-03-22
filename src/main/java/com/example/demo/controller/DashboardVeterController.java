package com.example.demo.controller;


import com.example.demo.pojo.Vet;
import com.example.demo.pojo.Veter;
import com.example.demo.service.VetService;
import com.example.demo.service.VeterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Dashboard Veter management")
@RestController
@RequestMapping(value = "dashveter")
public class DashboardVeterController {
    @Autowired
    VeterService veterService;
    @Autowired
    VetService vetService;

    @ApiOperation(value = "api to get a veter by veterid", notes = "", response = Veter.class)
    @GetMapping("/{veterid}")
    public Veter getByID(@PathVariable("veterid") Integer veterid) throws Exception {
        Veter veter = veterService.getByVeterID(veterid);
        return veter;
    }

    @ApiOperation(value = "api to get list of veter by vetid", notes = "", response = Veter.class)
    @GetMapping("/vet/{vetid}")
        public List<Veter> getByVetID(@PathVariable("vetid") Integer vetid) throws Exception {
        Vet vet = vetService.getByVetID(vetid);
        List<Veter> veter = veterService.getByVet(vet);
        return veter;
    }

    @ApiOperation(value = "api to add veter")
    @PostMapping("/add")
    public Object addVeter(@RequestBody Veter veter, @RequestParam Integer vetId ) throws Exception {
        Vet vet = vetService.getByVetID(vetId);
        veterService.addVeter(veter, vet);
        return new ResponseEntity("Veter added successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "api to edit veter profile")
    @PostMapping("/edit/profile")
    public Object editProfile(@RequestBody Veter veter) throws Exception {
        boolean status = veterService.edit(veter);
        if(status){

            return new ResponseEntity("Veter  profile updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Veter  profile updated fail", HttpStatus.OK);
    }


}
