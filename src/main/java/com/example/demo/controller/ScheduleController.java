package com.example.demo.controller;

import com.example.demo.pojo.Schedule;
import com.example.demo.pojo.Veter;
import com.example.demo.service.ScheduleService;
import com.example.demo.service.VeterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Working schedule management")
@RestController
@RequestMapping(value = "veterworkingschedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    VeterService veterService;

    @ApiOperation(value = "api to edit veter schedule")
    @PostMapping("/schedule/edit")
    public Object editschedule(@RequestParam Integer veterId,@RequestBody List<Schedule> scheduleList) throws Exception {
        Veter veter = veterService.getByVeterID(veterId);
        scheduleService.edit(veter ,scheduleList);
        return new ResponseEntity("Veter schedule updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "api to get working schedule by veterid")// , notes = "", response = Schedule.class
    @GetMapping("/schedule/{veterid}")
    public List<Schedule> getByVeterID(@PathVariable("veterid") Integer veterid) throws Exception {
        Veter veter = veterService.getByVeterID(veterid);
        return scheduleService.getByVeterID(veter);
    }

}
