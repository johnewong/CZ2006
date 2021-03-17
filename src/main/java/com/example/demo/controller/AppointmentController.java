package com.example.demo.controller;

import com.example.demo.pojo.Appointment;
import com.example.demo.service.AppointmentService;
import com.example.demo.viewmodel.DentistSlot;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(tags = "Appointment management")
@RestController
@RequestMapping(value = "appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @ApiOperation(value = "api to get all appointment by patientid")
    @GetMapping("/patient/{patientid}")
    public List<Appointment> getByPatientID(@PathVariable("patientid") Integer patientid) throws Exception {
        return appointmentService.getByPatientID(patientid);
    }


    @ApiOperation(value = "api to get an appointment by appointmentid", notes = "", response = Appointment.class)
    @GetMapping("/{appointmentid}")
    public Appointment getByAppointmentID(@PathVariable("appointmentid") Integer appointmentid) throws Exception {
        Appointment appointment = appointmentService.getByAppointmentID(appointmentid);
        return appointment;
    }

    @ApiOperation(value = "api to get available slot by dentalid and treatment and date. Date format = yyyy-MM-dd", notes = "", response = Appointment.class)
    @GetMapping("/{dentalid}/{treatmentid}/{date}")
    public List<DentistSlot> getByDentalIDAndTreatmentAndDate(@PathVariable("dentalid") Integer dentalid,@PathVariable("treatmentid") Integer treatmentid,@PathVariable("date") String date) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date formatdate = format.parse(date);
        List<DentistSlot> dentistSlots = appointmentService.getAvailableSlotByDentalIDAndTreamentID(dentalid,treatmentid,formatdate);
        return dentistSlots;
    }

    @ApiOperation(value = "api to cancel an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/cancel")
    public Object cancelAppointmnet(@RequestBody Integer appointmentid) throws Exception {
        Boolean status = appointmentService.cancelAppointment(appointmentid);
        if(status){

            return new ResponseEntity("Appointment cancelled successfully", HttpStatus.OK);
        }

        return new ResponseEntity("Appointment cancelled failed", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "api to add an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/add")
    public Object addAppointmnet(@RequestBody Appointment appointment) throws Exception {

        boolean status = appointmentService.addAppointment(appointment);

        if(status){

            return new ResponseEntity("Appointment added successfully", HttpStatus.OK);
        }

        return new ResponseEntity("Appointment slot is not available", HttpStatus.BAD_REQUEST);

    }



}
