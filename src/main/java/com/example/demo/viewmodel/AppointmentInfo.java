package com.example.demo.viewmodel;

import com.example.demo.pojo.Appointment;
import com.example.demo.pojo.Veter;
import com.example.demo.pojo.Treatment;
import com.example.demo.pojo.User;

public class AppointmentInfo {

     User customer;
     Appointment appointment;
     Veter veter;
     Treatment treatment;

     String startTimeFormat;
     String endTimeFormat;
     String appointmentDateFormat;

    String appointmentStatusFormat;

    String appointmentTimeFormat;
    public String getAppointmentStatusFormat() {
        return appointmentStatusFormat;
    }

    public void setAppointmentStatusFormat(String appointmentStatusFormat) {
        this.appointmentStatusFormat = appointmentStatusFormat;
    }

    public String getAppointmentTimeFormat() {
        return appointmentTimeFormat;
    }

    public void setAppointmentTimeFormat(String appointmentTimeFormat) {
        this.appointmentTimeFormat = appointmentTimeFormat;
    }

    public Treatment getTreatment() {
        return treatment;
    }

    public void setTreatment(Treatment treatment) {
        this.treatment = treatment;
    }

    public String getStartTimeFormat() {
        return startTimeFormat;
    }

    public void setStartTimeFormat(String startTimeFormat) {
        this.startTimeFormat = startTimeFormat;
    }

    public String getEndTimeFormat() {
        return endTimeFormat;
    }

    public void setEndTimeFormat(String endTimeFormat) {
        this.endTimeFormat = endTimeFormat;
    }

    public String getAppointmentDateFormat() {
        return appointmentDateFormat;
    }

    public void setAppointmentDateFormat(String appointmentDateFormat) {
        this.appointmentDateFormat = appointmentDateFormat;
    }


    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Veter getVeter() {
        return veter;
    }

    public void setVeter(Veter veter) {
        this.veter = veter;
    }
}
