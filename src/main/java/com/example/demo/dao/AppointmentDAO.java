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
    @Query("select a from Appointment a where a.dentalID = :DentalID and a.dentistID = :DentistID and a.isDeleted = false and a.appointmentDate = :AppointDate and a.appointmentStartTime < :EndTime and " +
            "a.appointmentEndTime > :EndTime")
    List<Appointment> findByDentalIDAndDentistIDAndPeriodAndIsDeletedFalse(
            @Param("DentalID") Integer dentalid,
            @Param("DentistID") Integer dentistID ,
            @Param("EndTime")  Date EndTime,
            @Param("AppointDate") Date AppointDate );

}
