package com.example.demo.controller;

import com.example.demo.pojo.Dental;
import com.example.demo.service.DentalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Dashboard Dental management")
@RestController
@RequestMapping(value = "dashboraddental")
public class DashboardDentalController {
    @Autowired
    DentalService dentalService;

    @ApiOperation(value = "api to get dental info")
    @GetMapping("/dental/{dentalid}")
    public Dental getByDentalID(@PathVariable("dentalid") Integer dentalid) throws Exception {
        Dental dental = dentalService.getByDentalID(dentalid);
        return dental;
    }

    @ApiOperation(value = "api to edit dental profile")
    @PostMapping("/dental/profile")
    public Object editProfile(@RequestBody Dental dental) throws Exception {
        dentalService.edit(dental);
        return new ResponseEntity("Dental profile updated successfully", HttpStatus.OK);
    }

}
