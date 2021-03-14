package com.example.demo.controller;

import com.example.demo.pojo.Dental;
import com.example.demo.service.DentalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Dental management")
@RestController
@RequestMapping(value = "dental")
public class DentalController {
    @Autowired
    DentalService dentalService;

    @ApiOperation(value = "api to get a dental by dentalid", notes = "", response = Dental.class)
    @GetMapping("/{dentalid}")
    public Dental getByID(@PathVariable("dentalid") Integer dentalid) throws Exception {
        Dental dental = dentalService.getByDentalID(dentalid);
        return dental;
    }


}
