package com.example.carproject.enums;

public enum BanType {
    AVTOBUS("Avtobus"),
    DARTQI("Dartqı"),
    FURQON("Furqon"),
    HETCBEK("Hetçbek / Liftbek"), /* HETCBEK/LIFBEK */
    KABRIO("Kabrio"),
    KARVAN("Karvan"),
    KUPE("Kupe"),
    KVADROSIKL("Kvadrosikl"),
    MIKRO_AVTOBUS("Mikroavtobus"),
    MINIVAN("Minivan"),
    MOTOSIKLET("Motosiklet"),
    OFFROADER("Offroader / SUV"),  /* OFFROADER/SUV */
    PIKAP("Pikap"),
    QOLFKAR("Qolfkar"),
    RODSTER("Rodster"),
    SEDAN("Sedan"),
    UNIVERSAL("Universal"),
    VAN("Van"),
    YUKMASINI("Yükmaşını");
    private final String value;

    BanType(final String value){
        this.value = value;
    }
    public String getValue(){
        return value;
    }
}
