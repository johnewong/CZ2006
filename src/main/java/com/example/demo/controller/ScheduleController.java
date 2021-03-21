package com.example.demo.controller;

import com.example.demo.service.ScheduleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Working schedule management")
@RestController
@RequestMapping(value = "veterworkingschedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;

   /* @ApiOperation(value = "api to get working schedule by veterid", notes = "", response = Schedule.class)
    @GetMapping("/veter/{veterid}")
    public List<Schedule> getByVeterID(@PathVariable("veterid") Integer veterid) throws Exception {
        List<Schedule> veterWorkingSchedule = scheduleService.getByVeterID(veterid);
        return veterWorkingSchedule;
    }*/
}
