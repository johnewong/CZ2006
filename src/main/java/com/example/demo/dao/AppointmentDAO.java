package com.example.demo.dao;

import com.example.demo.pojo.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO extends JpaRepository<Appointment,Integer> {

    Appointment findByAppointmentNumberAndIsDeletedFalse(String AppointmentNumber);
    Appointment findByAppointmentIDAndIsDeletedFalse(Integer AppointmentID);
    List<Appointment> findByPatientIDAndIsDeletedFalse(Integer patientID,Sort sort);
    List<Appointment> findByVetIDAndIsDeletedFalse(Integer vetID,Sort sort);
    List<Appointment> findByVetIDAndAppointmentDateAndIsDeletedFalse(Integer vetID, Date appointmentDate, Sort sort);

    @Query(value = "select * from Appointment a where a.vetID = :VetID " +
            "and a.veterID = :VeterID " +
            "and a.isDeleted = false and a.status != 2 and a.appointmentDate = :AppointDate " +
            "and ((a.appointmentStartTime < :EndTime and a.appointmentEndTime >= :EndTime)" +
            "or (a.appointmentStartTime <= :StartTime and a.appointmentEndTime > :StartTime))", nativeQuery = true)

    List<Appointment> findByVetIDAndVeterIDAndPeriodAndIsDeletedFalse(
            @Param("VetID") Integer vetid,
            @Param("VeterID") Integer veterID ,
            @Param("AppointDate") Date AppointDate,
            @Param("StartTime")  Date StartTime,
            @Param("EndTime")  Date EndTime);

}
