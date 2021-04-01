package com.example.demo.utility;

public enum LocationMapper {
    CentralSouth(3, "Central South"), Keppel(4, "Keppel"), SouthWest(5, "South West");

    private int number;
    private String value;

    public int toInt(){
        return this.number;
    }

    private LocationMapper(int number, String value){
        this.number=number;
        this.value=value;
    }

    public String toString() {
        return value;
    }
    public static String getValue(int number){
        if(number == CentralSouth.number)
            return CentralSouth.value;
        if(number == Keppel.number)
            return Keppel.value;
        if(number == SouthWest.number)
            return SouthWest.value;

        return "";
    }
}
