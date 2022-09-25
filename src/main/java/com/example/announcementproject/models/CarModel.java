package com.example.announcementproject.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car_model")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class CarModel{

    @Id
    @Column(name = "id",nullable = false)
     Integer id;

    @Column(name = "model_name",nullable = false)
    String modelName;

    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    CarBrand brandId;

    @OneToMany(mappedBy = "modelId", fetch = FetchType.LAZY)
    Collection<Announcement> announcements;


    public CarModel(Integer id) {
        this.id = id;
    }
}
