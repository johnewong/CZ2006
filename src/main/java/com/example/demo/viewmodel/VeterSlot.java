package com.example.demo.viewmodel;

import com.example.demo.pojo.Veter;

import java.util.List;

public class VeterSlot {
    Veter veter;


    List<AvailableSlot> availableSlots;


    public List<AvailableSlot> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<AvailableSlot> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public Veter getVeter() {
        return veter;
    }

    public void setVeter(Veter veter) {
        this.veter = veter;
    }
}
