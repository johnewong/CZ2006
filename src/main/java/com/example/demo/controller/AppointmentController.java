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
    /**
     * This method gets the appointment list by customer ID.
     * @param userid user ID.
     * @return the appointment list.
     */
    public  List<AppointmentInfo>  getByCustomerIDAndMoreThanNow(@PathVariable("customerid") Integer customerid) throws Exception {
        return  appointmentService.getByCustomerIDAndMoreThanNow(customerid);
    }

    @ApiOperation(value = "api to get an appointment by appointmentid", notes = "", response = Appointment.class)
    @GetMapping("/{appointmentid}")
    /**
     * This method gets an appointment by appointment ID.
     * @param appointmentid appointment ID.
     * @return the appointment information.
     */
    public Appointment getByAppointmentID(@PathVariable("appointmentid") Integer appointmentid) throws Exception {
        Appointment appointment = appointmentService.getByAppointmentID(appointmentid);
        return appointment;
    }

    @ApiOperation(value = "api to get available slot by vetid and treatment and date. Date format = yyyy-MM-dd", notes = "", response = Appointment.class)
    @GetMapping("/{vetid}/{treatmentid}/{date}")
    /**
     * This method gets available slot by vet ID, treatment ID and date.
     * @param vetid vet ID.
     * @param treatmentid treatment ID.
     * @param date date.
     * @return the available slot.
     */
    public List<VeterSlot> getByVeterIDAndTreatmentAndDate(@PathVariable("vetid") Integer vetid, @PathVariable("treatmentid") Integer treatmentid, @PathVariable("date") String date) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        format.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        Date formatdate = format.parse(date);
        List<VeterSlot> veterSlots = appointmentService.getAvailableSlotByVetIDAndTreatmentID(vetid,treatmentid,formatdate);
        return veterSlots;
    }

    @ApiOperation(value = "api to cancel an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/cancel")
    /**
     * This method cancels an appointment by appointment ID.
     * @param appointmentid appointment ID.
     * @return false the appointment status.
     */
    public Boolean cancelAppointmnet(@RequestBody Integer appointmentid) throws Exception {
        Boolean status = appointmentService.cancelAppointmentByID(appointmentid);

        return status;
    }

    @ApiOperation(value = "api to add an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/add")
    /**
     * This method adds an appointment.
     * @param appointment appointment information.
     * @return message "Appointment added successfully".
     */
    public Object addAppointmnet(@RequestBody Appointment appointment) throws Exception {

        boolean status = appointmentService.addAppointment(appointment);

        if(status){

            return new ResponseEntity("Appointment added successfully", HttpStatus.OK);
        }

        return new ResponseEntity("Appointment slot is not available", HttpStatus.BAD_REQUEST);

    }



}
