package com.example.announcementproject.model;

import com.example.announcementproject.enums.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "announcements")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user;

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    CarBrand brandId;

    @ManyToOne
    @JoinColumn(name = "model_id", referencedColumnName = "id")
    CarModel modelId;

    @Enumerated(EnumType.STRING)
    @Column(name = "ban_type", nullable = false)
    BanType banType;

    @Column(name = "mileage", nullable = false)
    Integer mileage;

    @Enumerated(EnumType.STRING)
    @Column(name = "mileage_type", columnDefinition = "varchar(32) default 'KM'")
    MileageType mileageType;

    @Column(name = "color", nullable = false)
    String color;

    @Column(name = "price", nullable = false)
    Double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency", nullable = false)
    Currency currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "owners_number", columnDefinition = "varchar(32) default 'NULL'")
    OwnersNumber ownersNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "fuel_type", nullable = false)
    FuelType fuelType;

    @Enumerated(EnumType.STRING)
    @Column(name = "transmitter", nullable = false)
    Transmitter transmitter;

    @Enumerated(EnumType.STRING)
    @Column(name = "gearbox", nullable = false)
    Gearbox gearbox;

    @Min(1902) @Max(2022)
    @Column(name = "car_year", nullable = false)
    Integer carYear;

    @Column(name = "engine_volume", nullable = false)
    Double engineVolume;

    @Column(name = "engine_power", nullable = false)
    Integer enginePower;

    @Enumerated(EnumType.STRING)
    @Column(name = "market_address", columnDefinition = "varchar(32) default 'NULL'")
    MarketAddresses marketAddresses;

    @Enumerated(EnumType.STRING)
    @Column(name = "repair", columnDefinition = "varchar(32) default 'NULL'")
    Repair repair;

    @Enumerated(EnumType.STRING)
    @Column(name = "seats_number", columnDefinition = "varchar(32) default 'NULL'")
    SeatsNumber seatsNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "vendor_type", columnDefinition = "varchar(32) default 'NULL'")
    VendorType vendorType;

    @Enumerated(EnumType.STRING)
    @Column(name = "sales_type", columnDefinition = "varchar(32) default 'NULL'")
    SalesType salesType;

    @Column(columnDefinition = "TEXT")
    String description;

    @Column(columnDefinition = "TEXT", name = "vehicle_equip")
    String vehicleEquip;
}
