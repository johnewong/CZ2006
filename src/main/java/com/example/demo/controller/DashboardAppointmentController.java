package com.example.demo.controller;

import com.example.demo.pojo.Appointment;
import com.example.demo.service.AppointmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "Dashboard Appointment management")
@RestController
@RequestMapping(value = "dashboradappointment")
public class DashboardAppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @ApiOperation(value = "api to get list of appointment by dentalid")
    @GetMapping("/{dentalid}")
    public List<Appointment> getByDentalID(@PathVariable("dentalid") Integer dentalid) throws Exception {
        return  appointmentService.getByDentalID(dentalid);

    }

    @ApiOperation(value = "api to cancel an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/cancel")
    public Object cancelAppointment(@RequestBody Integer appointmentid) throws Exception {
        Boolean status = appointmentService.cancelAppointment(appointmentid);
        if(status){

            return new ResponseEntity("Appointment cancelled successfully", HttpStatus.OK);
        }

        return new ResponseEntity("Appointment cancelled failed", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "api to edit appointment")
    @PostMapping("/")
    public Object edit(@RequestBody Appointment appointment) throws Exception {

        Boolean status = appointmentService.edit(appointment);
        if(status){

            return new ResponseEntity("Appointment edit successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Appointment edit failed", HttpStatus.BAD_REQUEST);
    }
}
