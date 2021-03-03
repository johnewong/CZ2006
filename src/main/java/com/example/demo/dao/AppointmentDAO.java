package com.example.demo.dao;

import com.example.demo.pojo.Appointment;
import com.example.demo.pojo.Dental;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentDAO extends JpaRepository<Appointment,Integer> {

    Appointment findByAppointmentID(Integer AppointmentID);
    List<Appointment> findByPatientID(Integer patientID,Sort sort);
}
