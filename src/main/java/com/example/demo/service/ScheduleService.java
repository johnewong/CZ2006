package com.example.demo.service;

import com.example.demo.dao.ScheduleDAO;
import com.example.demo.pojo.Schedule;
import com.example.demo.pojo.Veter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    ScheduleDAO scheduleDAO;

   public List<Schedule> getByVeterID(Veter veter) {
        return scheduleDAO.findAllByVeterAndIsDeletedFalse(veter);}

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


   public void add(Schedule schedule,Veter veter){
       Schedule scheduleMode = new Schedule();
       scheduleMode.setCreatedBy(schedule.getCreatedBy());
       scheduleMode.setDayOfWeek(schedule.getDayOfWeek());
       scheduleMode.setStartTime(schedule.getStartTime());
       scheduleMode.setUpdatedBy(schedule.getUpdatedBy());
       scheduleMode.setStartTime(schedule.getStartTime());
       scheduleMode.setEndTime(schedule.getEndTime());
       scheduleMode.setVeter(veter);
       scheduleDAO.save(scheduleMode);

   }




   public void edit(Veter veter,  List<Schedule> scheduleList){
       List<Schedule> oldscheduleList = getByVeterID(veter);
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
               scheduleDAO.save(scheduleMode);
           } else {
               add(newschedule, veter);
           }

       }

   }
}
