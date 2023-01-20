package com.example.announcementproject.enums;

public enum MarketAddresses {
    AMERIKA("Amerika"),
    AVROPA("Avropa"),
    DUBAY("Dubay"),
    KOREYA("Koreya"),
    RESMI_DILER("Rəsmi diler"),
    RUSIYA("Rusiya"),
    YAPONIYA("Yaponiya"),
    DIGER("Digər"),
    NULL("Null");
    private final String value;

    MarketAddresses(final String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
