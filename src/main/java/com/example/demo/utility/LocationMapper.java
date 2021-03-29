package com.example.demo.utility;

public enum LocationMapper {
    JurongWest(0, "Jurong West"), BoonLay(1, "BoonLay"), Others(3, "Others");

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
        if(number == JurongWest.number)
            return JurongWest.value;
        if(number == BoonLay.number)
            return BoonLay.value;
        if(number == Others.number)
            return Others.value;

        return "Not found";
    }
}
