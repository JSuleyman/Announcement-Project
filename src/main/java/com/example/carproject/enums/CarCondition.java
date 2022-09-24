package com.example.carproject.enums;

public enum CarCondition {
    HAMISI("Hamısı"),
    YENI("Yeni"),
    SURULMUS("Sürülmüş");

    private final String value;

    CarCondition(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
