package com.example.demo.controller;

import com.example.demo.pojo.DentistWorkingSchedule;
import com.example.demo.service.DentistWorkingScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Working schedule management")
@RestController
@RequestMapping(value = "dentistworkingschedule")
public class DentistWorkingScheduleController {
    @Autowired
    DentistWorkingScheduleService dentistWorkingScheduleService;

    @ApiOperation(value = "api to get working schedule by dentistid", notes = "", response = DentistWorkingSchedule.class)
    @GetMapping("/dentistworkingschedule/{dentistid}")
    public DentistWorkingSchedule get(@PathVariable("dentistid") Integer dentistid) throws Exception {
        DentistWorkingSchedule dentistWorkingSchedule = dentistWorkingScheduleService.getbydentistid(dentistid);
        return dentistWorkingSchedule;
    }
}
