package com.example.demo.viewmodel;

import com.example.demo.pojo.Dentist;

import java.util.List;

public class DentistSlot {
    Dentist dentist;


    List<AvailableSlot> availableSlots;


    public List<AvailableSlot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }
}
