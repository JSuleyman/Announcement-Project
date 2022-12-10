package com.example.announcementproject.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car_brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarBrand {

    @Id
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "brand_name", nullable = false)
    String brandName;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "brandId",fetch = FetchType.LAZY)
    Collection<CarModel> carModelCollection;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "brandId", fetch = FetchType.LAZY)
    Collection<Announcement> announcements;

    public CarBrand(Integer id) {
        this.id = id;
    }
}
