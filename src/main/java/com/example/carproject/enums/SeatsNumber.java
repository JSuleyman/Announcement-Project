package com.example.carproject.enums;

public enum SeatsNumber {
    BIR("1"),
    IKI("2"),
    UC("3"),
    DORD("4"),
    BES("5"),
    ALTI("6"),
    YEDDI("7"),
    SEKKIZ_VE_DAHA_COX("8+"),
    NULL("Null");

    private final String value;

    SeatsNumber(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }

}
