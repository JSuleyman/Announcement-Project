package com.example.announcementproject.enums;

public enum VendorType {
    HAMISI("Hamısı"),
    AVTOSALONLAR("Avtosalonlar"),
    SEXSI("Şəxsi"),
    NULL("Null");
    private final String value;

    VendorType(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
