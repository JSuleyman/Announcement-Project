package com.example.carproject.enums;

public enum Transmitter {
    ARXA("Arxa"),
    ON("Ön"),
    TAM("Tam");
    private final String value;

    Transmitter(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }

}
