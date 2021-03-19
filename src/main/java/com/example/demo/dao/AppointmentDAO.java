package com.example.demo.dao;

import com.example.demo.pojo.Appointment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AppointmentDAO extends JpaRepository<Appointment,Integer> {

    Appointment findByAppointmentIDAndIsDeletedFalse(Integer AppointmentID);
    List<Appointment> findByPatientIDAndIsDeletedFalse(Integer patientID,Sort sort);
    List<Appointment> findByDentalIDAndIsDeletedFalse(Integer dentalID,Sort sort);
    List<Appointment> findByDentalIDAndAppointmentDateAndIsDeletedFalse(Integer dentalID, Date appointmentDate, Sort sort);

    @Query(value = "select * from Appointment a where a.dentalID = :DentalID " +
            "and a.dentistID = :DentistID " +
            "and a.isDeleted = false and a.status != 2 and a.appointmentDate = :AppointDate " +
            "and ((a.appointmentStartTime <= :EndTime and a.appointmentEndTime >= :EndTime)" +
            "or (a.appointmentStartTime <= :StartTime and a.appointmentEndTime >= :StartTime))", nativeQuery = true)
    List<Appointment> findByDentalIDAndDentistIDAndPeriodAndIsDeletedFalse(
            @Param("DentalID") Integer dentalid,
            @Param("DentistID") Integer dentistID ,
            @Param("AppointDate") Date AppointDate,
            @Param("StartTime")  Date StartTime,
            @Param("EndTime")  Date EndTime);

}
