package com.example.carproject.enums;

public enum Gearbox {
    MEXANIKA("Mexanika"),
    AVTOMAT("Avtomat"),
    ROBOTLASDIRILMIS("Robotlaşdırılmış"),
    VARIATOR("Variator");

    private final String value;

    Gearbox(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }


}
