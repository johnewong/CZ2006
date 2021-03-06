package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.example.demo.pojo.Dental;
import com.example.demo.service.DentalService;

import java.util.List;
import java.util.Date;

@Api(tags = "Dental management")
@RestController
@RequestMapping(value = "dental")
public class DentalController {
    @Autowired
    DentalService dentalService;

    @ApiOperation(value = "api to get all dentals")
    @GetMapping("")
    public List<Dental> getall() throws Exception {
        return dentalService.list();
    }

    @ApiOperation(value = "api to get a dental by dentalid", notes = "", response = Dental.class)
    @GetMapping("/{dentalid}")
    public Dental getByID(@PathVariable("dentalid") Integer dentalid) throws Exception {
        Dental dental = dentalService.getByID(dentalid);
        return dental;
    }

    @ApiOperation(value = "api to update dental info", notes = "", response = Dental.class)
    @PostMapping("/edit")
    public Object edit(@RequestBody Dental dental) throws Exception {

        dentalService.edit(dental);

        return new ResponseEntity("Dental updated successfully", HttpStatus.OK);

    }


}
