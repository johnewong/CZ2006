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

@Api(tags = "Dashboard Appointment management")
@RestController
@RequestMapping(value = "dashappointment")
public class DashboardAppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @ApiOperation(value = "api to get list of appointment by vetid")
    @GetMapping("/{vetid}")
    /**
     * This method return the appointment list by vet ID.
     * @param vetid vet ID.
     * @return this vet's all appointments.
     */
    public  List<AppointmentInfo> getByVetID(@PathVariable("vetid") Integer vetid) throws Exception {
        return  appointmentService.getByVetID(vetid);
    }

    @ApiOperation(value = "api to cancel an appointment by appointmentid", notes = "", response = Appointment.class)
    @PostMapping("/cancel")
    public Boolean cancelAppointment(@RequestBody Integer appointmentid) throws Exception {
        Boolean status = appointmentService.cancelAppointmentByID(appointmentid);

        return status;
    }

    @ApiOperation(value = "api to cancel an appointment by appointmentNumber", notes = "", response = Appointment.class)
    @PostMapping("/appointmentNumber/cancel")
    public Boolean cancelAppointment(@RequestBody String appointmentNumber) throws Exception {
        Boolean status = appointmentService.cancelAppointmentByNumber(appointmentNumber);

        return status;
    }

    @ApiOperation(value = "api to edit appointment")
    @PostMapping("/edit")
    public Object edit(@RequestBody Appointment appointment) throws Exception {

        Boolean status = appointmentService.edit(appointment);
        if(status){

            return new ResponseEntity("Appointment edit successfully", HttpStatus.OK);
        }
        return new ResponseEntity("Appointment edit failed", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "api to get available slot by vetid and treatment and date. Date format = yyyy-MM-dd", notes = "", response = Appointment.class)
    @GetMapping("/{vetid}/{treatmentid}/{date}")
    public List<VeterSlot> getByVetIDAndTreatmentAndDate(@PathVariable("vetid") Integer vetid, @PathVariable("treatmentid") Integer treatmentid, @PathVariable("date") String date) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date formatdate = format.parse(date);
        List<VeterSlot> veterSlots = appointmentService.getAvailableSlotByVetIDAndTreatmentID(vetid,treatmentid,formatdate);
        return veterSlots;
    }


}
