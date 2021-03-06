package com.example.demo.dao;

import com.example.demo.pojo.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentDAO extends JpaRepository<Appointment,Integer> {

    Appointment findByAppointmentIDAndIsDeletedFalse(Integer AppointmentID);
    List<Appointment> findByPatientIDAndIsDeletedFalse(Integer patientID,Sort sort);

}
