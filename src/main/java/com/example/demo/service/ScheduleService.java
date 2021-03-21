package com.example.demo.service;

import com.example.demo.dao.DentistDAO;
import com.example.demo.dao.ScheduleDAO;
import com.example.demo.pojo.Dental;
import com.example.demo.pojo.Dentist;
import com.example.demo.pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.util.*;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;

   public List<Schedule> getByDentistID(Dentist dentist) {
        return scheduleDAO.findAllByDentistAndIsDeletedFalse(dentist);}

   public Schedule findScheduleByWeekofday(List<Schedule> oldscheduleList, Integer weekOfDay){
       Schedule item =null;
       for (Schedule newschedule : oldscheduleList) {
           if (newschedule.getDayOfWeek().equals(weekOfDay)) {
               item = scheduleDAO.findScheduleByScheduleID(newschedule.getScheduleID());
               break;
           }
       }
       return item;
   }


   public void add(Schedule schedule,Dentist dentist){
       Schedule scheduleMode = new Schedule();
       scheduleMode.setCreatedBy(schedule.getCreatedBy());
       scheduleMode.setDayOfWeek(schedule.getDayOfWeek());
       scheduleMode.setStartTime(schedule.getStartTime());
       scheduleMode.setUpdatedBy(schedule.getUpdatedBy());
       scheduleMode.setStartTime(schedule.getStartTime());
       scheduleMode.setEndTime(schedule.getEndTime());
       scheduleMode.setBreakStartTime(schedule.getBreakEndTime());
       scheduleMode.setBreakEndTime(schedule.getBreakEndTime());
       scheduleMode.setDentist(dentist);
       scheduleDAO.save(scheduleMode);

   }




   public void edit(Dentist dentist,  List<Schedule> scheduleList){
       List<Schedule> oldscheduleList = getByDentistID(dentist);
       List<Integer> DayofweekList = new ArrayList<>();
       for (Schedule newschedule : oldscheduleList) {
           DayofweekList.add(newschedule.getDayOfWeek());
           Schedule item = scheduleDAO.findScheduleByScheduleID(newschedule.getScheduleID());
           item.setIsDeleted(true);
           scheduleDAO.save(item);
       }

       for (Schedule newschedule : scheduleList) {
           Integer newWeekofDay = newschedule.getDayOfWeek();
           if (DayofweekList.contains(newWeekofDay)) {
               Schedule scheduleMode = findScheduleByWeekofday(oldscheduleList, newWeekofDay);
               scheduleMode.setIsDeleted(false);
               scheduleMode.setStartTime(newschedule.getStartTime());
               scheduleMode.setUpdatedBy(newschedule.getUpdatedBy());
               scheduleMode.setStartTime(newschedule.getStartTime());
               scheduleMode.setEndTime(newschedule.getEndTime());
               scheduleMode.setBreakStartTime(newschedule.getBreakEndTime());
               scheduleMode.setBreakEndTime(newschedule.getBreakEndTime());
               scheduleDAO.save(scheduleMode);
           } else {
               add(newschedule, dentist);
           }

       }

   }
}
