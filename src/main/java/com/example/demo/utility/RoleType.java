package com.example.demo.utility;

public enum RoleType {
    Customer(0), Admin(1);

    private int number;

    public int toInt() {
        return this.number;
    }

    private RoleType(int number) {
        this.number = number;
    }
}