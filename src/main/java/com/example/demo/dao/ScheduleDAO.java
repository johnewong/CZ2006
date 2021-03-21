package com.example.demo.dao;

import com.example.demo.pojo.Dentist;
import com.example.demo.pojo.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleDAO extends JpaRepository<Schedule,Integer>{

// List<Schedule> findSchedulesByDentistAndAndIsDeletedFalse(Dentist dentist);
 List<Schedule> findAllByDentistAndIsDeletedFalse(Dentist dentist);
 Schedule findScheduleByScheduleID(Integer schduleId);

}