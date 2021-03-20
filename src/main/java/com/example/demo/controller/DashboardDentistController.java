package com.example.demo.controller;


import com.example.demo.pojo.Dental;
import com.example.demo.pojo.Dentist;
import com.example.demo.service.DentalService;
import com.example.demo.service.DentistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Dentist management")
@RestController
@RequestMapping(value = "dentist")
public class DashboardDentistController {
    @Autowired
    DentistService dentistService;
    @Autowired
    DentalService dentalService;

    @ApiOperation(value = "api to get a dentist by dentistid", notes = "", response = Dentist.class)
    @GetMapping("/{dentistid}")
    public Dentist getByID(@PathVariable("dentistid") Integer dentistlid) throws Exception {
        return dentistService.getDentistInfobyDentistID(dentistlid);
    }
    @ApiOperation(value = "api to add dentist")
    @PostMapping("/add")
    public Object addDentist(@RequestBody Dentist dentist, @RequestParam Integer dentalId ) throws Exception {
        Dental dental = dentalService.getByDentalID(dentalId);
        dentistService.addDentist(dentist, dental);
        return new ResponseEntity("Dentist added successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "api to edit dentist profile")
    @PostMapping("/dentist/profile")
    public Object editProfile(@RequestBody Dentist dentist) throws Exception {
        dentistService.edit(dentist);
        return new ResponseEntity("Dentist  profile updated successfully", HttpStatus.OK);
    }


}
