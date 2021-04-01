package com.example.demo.utility;

public enum LocationMapper {
    CentralSouth(3, "Central South"), Keppel(4, "Keppel"), SouthWest(5, "South West"),
    LittleIndia(8, "Little India"),Tanglin(10, "Tanglin"),Newton(11, "Newton"),
    ToaPayoh(12, "Toa Payoh"),CentralEast(13, "Central East"),Eunos(14, "Eunos"),
    EastCoast(15, "East Coast"),UpperEastCoast(16, "Upper East Coast"),FarEast(17, "Far East"),
    Tampines(18, "Tampines"),NorthEast(19, "North East"),AngMoKio(20, "Ang Mo Kio"),
    CentralWest(21, "Central West"),FarWest(22, "Far West"),NorthWest(23, "North West"),
    FarNorthWest(24, "Far North West"),FarNorth(25, "Far North"),FarNorthEast(27, "Far North East");

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
