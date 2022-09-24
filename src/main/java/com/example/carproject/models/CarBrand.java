package com.example.carproject.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car_brand")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CarBrand {

    @Id
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "brand_name", nullable = false)
    String brandName;

    @OneToMany(mappedBy = "brandId",fetch = FetchType.LAZY)
    Collection<CarModel> carModelCollection;

    @OneToMany(mappedBy = "brandId", fetch = FetchType.LAZY)
    Collection<Announcement> announcements;

    public CarBrand(Integer id) {
        this.id = id;
    }
}
