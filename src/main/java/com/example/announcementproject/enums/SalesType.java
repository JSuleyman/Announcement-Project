package com.example.announcementproject.enums;

public enum SalesType {
    KREDIT("Kredit"),
    BARTER("Barter"),
    KREDIT_BARTER("Kredit,barter"),
    NULL("Null");

    private final String value;

    SalesType(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
