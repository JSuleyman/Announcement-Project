package com.example.announcementproject.enums;

public enum MileageType {
    KM("KM"),
    MI("mi");

    private final String value;

    MileageType(final String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
