package com.example.demo.model;

import com.example.demo.pojo.Vet;

import java.util.List;
public class VetSlot {
    Vet Vet;
    List<VeterSlot> VeterSlot;

    public com.example.demo.pojo.Vet getVet() {
        return Vet;
    }

    public void setVet(com.example.demo.pojo.Vet vet) {
        Vet = vet;
    }

    public List<com.example.demo.model.VeterSlot> getVeterSlot() {
        return VeterSlot;
    }

    public void setVeterSlot(List<com.example.demo.model.VeterSlot> veterSlot) {
        VeterSlot = veterSlot;
    }
}
