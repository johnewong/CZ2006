package com.example.demo.controller;

import com.example.demo.pojo.Schedule;
import com.example.demo.service.ScheduleService;
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
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

    @ApiOperation(value = "api to get working schedule by dentistid", notes = "", response = Schedule.class)
    @GetMapping("/dentist/{dentistid}")
    public List<Schedule> getByDentistID(@PathVariable("dentistid") Integer dentistid) throws Exception {
        List<Schedule> dentistWorkingSchedule = scheduleService.getByDentistID(dentistid);
        return dentistWorkingSchedule;
    }
}
