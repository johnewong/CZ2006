package com.example.demo.controller;

import com.example.demo.pojo.Dentist;
import com.example.demo.pojo.Schedule;
import com.example.demo.service.DentistService;
import com.example.demo.service.ScheduleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Working schedule management")
@RestController
@RequestMapping(value = "dentistworkingschedule")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    DentistService dentistService;

    @ApiOperation(value = "api to edit dentist schedule")
    @PostMapping("/schedule/edit")
    public Object editschedule(@RequestParam Integer dentistId,@RequestBody List<Schedule> scheduleList) throws Exception {
        Dentist dentist = dentistService.getDentistInfobyDentistID(dentistId);
        scheduleService.edit(dentist ,scheduleList);
        return new ResponseEntity("Dentist schedule updated successfully", HttpStatus.OK);
    }

    @ApiOperation(value = "api to get working schedule by dentistid")// , notes = "", response = Schedule.class
    @GetMapping("/schedule/{dentistid}")
    public List<Schedule> getByDentistID(@PathVariable("dentistid") Integer dentistid) throws Exception {
      Dentist dentist = dentistService.getDentistInfobyDentistID(dentistid);
        return scheduleService.getByDentistID(dentist);
    }

}
