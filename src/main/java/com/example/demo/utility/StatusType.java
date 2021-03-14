package com.example.demo.utility;

public enum StatusType {
    Pending(0, "Pending"), Confirmed(1, "Confirmed"), Cancel(2, "Cancel"), Expired(3, "Expire");

    private int number;
    private String value;

    public int toInt(){
        return this.number;
    }

    private StatusType(int number, String value){

        this.number=number;
        this.value=value;
    }

    public String toString() {
        return value;
    }
    public static String getValue(int number){
        if(number == Pending.number)
            return Pending.value;
        if(number == Confirmed.number)
            return Confirmed.value;
        if(number == Cancel.number)
            return Cancel.value;
        if(number == Expired.number)
            return Expired.value;

        return "Not found";
    }
}
