package com.example.announcementproject.enums;

public enum FuelType {
    BENZIN("Benzin"),
    DIZEL("Dizel"),
    QAZ("Qaz"),
    ELEKTRO("Elektro"),
    HIBRID("Hibrid"),
    PLUG_IN_HIBRID("Plug-in Hibrid");

    private final String value;

    FuelType(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
