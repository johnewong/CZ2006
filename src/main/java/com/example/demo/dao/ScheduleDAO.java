package com.example.demo.dao;

import com.example.demo.pojo.Veter;
import com.example.demo.pojo.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ScheduleDAO extends JpaRepository<Schedule,Integer>{

// List<Schedule> findSchedulesByVeterAndAndIsDeletedFalse(Veter veter);
 List<Schedule> findAllByVeterAndIsDeletedFalse(Veter veter);
 Schedule findScheduleByScheduleID(Integer schduleId);
 @Transactional
 @Modifying
 @Query(value = "truncate table veter_working_schedule",nativeQuery = true)
 public void truncateTable();

}