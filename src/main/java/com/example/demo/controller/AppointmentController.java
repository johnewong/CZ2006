package com.example.demo.controller;

import com.example.demo.pojo.Appointment;
import com.example.demo.service.AppointmentService;
import com.example.demo.viewmodel.AppointmentInfo;
import com.example.demo.viewmodel.VeterSlot;
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
import java.util.TimeZone;

@Api(tags = "Appointment management")
@RestController
@RequestMapping(value = "appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @ApiOperation(value = "api to get all appointment by customerid")
    @GetMapping("/customer/{customerid}")
    public  List<AppointmentInfo>   getByCustomerIDAndMoreThanNow(@PathVariable("userid") Integer userid) throws Exception {
        return  appointmentService.getByCustomerIDAndMoreThanNow(userid);
    }

    @ApiOperation(value = "api to get an appointment by appointmentid", notes = "", response = Appointment.class)
    @GetMapping("/{appointmentid}")
    public Appointment getByAppointmentID(@PathVariable("appointmentid") Integer appointmentid) throws Exception {
        Appointment appointment = appointmentService.getByAppointmentID(appointmentid);
        return appointment;
    }

    @ApiOperation(value = "api to get available slot by vetid and treatment and date. Date format = yyyy-MM-dd", notes = "", response = Appointment.class)
    @GetMapping("/{vetid}/{treatmentid}/{date}")
    public List<VeterSlot> getByVeterIDAndTreatmentAndDate(@PathVariable("vetid") Integer vetid, @PathVariable("treatmentid") Integer treatmentid, @PathVariable("date") String date) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        Date formatdate = format.parse(date);
        List<VeterSlot> veterSlots = appointmentService.getAvailableSlotByVetIDAndTreatmentID(vetid,treatmentid,formatdate);
        return veterSlots;
    }

    @ApiOperation(value = "api to cancel an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/cancel")
    public Boolean cancelAppointmnet(@RequestBody Integer appointmentid) throws Exception {
        Boolean status = appointmentService.cancelAppointmentByID(appointmentid);

        return status;
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
