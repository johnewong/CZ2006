package com.example.demo.dao;

import com.example.demo.pojo.Veter;
import com.example.demo.pojo.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ScheduleDAO extends JpaRepository<Schedule,Integer>{

// List<Schedule> findSchedulesByVeterAndAndIsDeletedFalse(Veter veter);
 List<Schedule> findAllByVeterAndIsDeletedFalse(Veter veter);
 Schedule findScheduleByScheduleID(Integer schduleId);

}