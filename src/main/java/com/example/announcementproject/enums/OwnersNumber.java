package com.example.announcementproject.enums;

public enum OwnersNumber {
    BIR("1"),
    IKI("2"),
    UC("3"),
    DORD_VE_DAHA_COX("4 ve daha cox"),
    NULL("Null");

    private final String value;

    OwnersNumber(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
