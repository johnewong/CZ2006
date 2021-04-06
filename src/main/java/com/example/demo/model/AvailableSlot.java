package com.example.demo.model;

import java.util.Date;

public class AvailableSlot {



        Boolean Available;
        Date StartTime;
        Date EndTime;
        public Date getStartTime() {
            return StartTime;
        }

        public void setStartTime(Date startTime) {
            StartTime = startTime;
        }

        public Date getEndTime() {
            return EndTime;
        }

        public void setEndTime(Date endTime) {
            EndTime = endTime;
        }

        public Boolean getAvailable() {
            return Available;
        }

        public void setAvailable(Boolean available) {
            Available = available;
        }

}
