package com.example.demo.viewmodel;

import com.example.demo.pojo.*;

public class AppointmentInfo {

    User customer;
    Appointment appointment;
    Vet vet;
    Veter veter;
    Treatment treatment;
    String startTimeFormat;
    String endTimeFormat;
    String appointmentDateFormat;
    String appointmentStatusFormat;
    String appointmentStartTimeFormat;
    String appointmentEndTimeFormat;

    public String getAppointmentStartTimeFormat() {
        return appointmentStartTimeFormat;
    }

    public void setAppointmentStartTimeFormat(String appointmentStartTimeFormat) {
        this.appointmentStartTimeFormat = appointmentStartTimeFormat;
    }

    public String getAppointmentEndTimeFormat() {
        return appointmentEndTimeFormat;
    }

    public void setAppointmentEndTimeFormat(String appointmentEndTimeFormat) {
        this.appointmentEndTimeFormat = appointmentEndTimeFormat;
    }

    public String getAppointmentStatusFormat() {
        return appointmentStatusFormat;
    }

    public void setAppointmentStatusFormat(String appointmentStatusFormat) {
        this.appointmentStatusFormat = appointmentStatusFormat;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
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
