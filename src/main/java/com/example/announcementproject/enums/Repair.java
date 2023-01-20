package com.example.announcementproject.enums;

public enum Repair {
    VURUGU_YOXDUR("Vuruğu yoxdur"),
    RENGLENMEYIB("Rənglənməyib"),
    VURUGU_YOXDUR_VE_RENGLENMEYIB("Vuruğu yoxdur,rənglənməyib"),
    NULL("Null");


    private String value;

    Repair(){}
    Repair(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
