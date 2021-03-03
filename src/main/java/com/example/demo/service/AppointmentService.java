package com.example.demo.service;

import com.example.demo.dao.AppointmentDAO;
import com.example.demo.pojo.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    @Autowired AppointmentDAO appointmentDAO;

    public void add(Appointment appointment){
        appointmentDAO.save(appointment);
    }

    public Appointment getByAppointmentID(Integer appointmentid) {
        return appointmentDAO.findByAppointmentID(appointmentid);
    }

    public List<Appointment> getByPatientID(Integer patientid) {
        return appointmentDAO.findByPatientID(patientid,Sort.by(Sort.Direction.DESC, "appointmentDate"));
    }



}
