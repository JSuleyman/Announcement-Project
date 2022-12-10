package com.example.announcementproject.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "car_model")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CarModel{
    @Id
    @Column(name = "id",nullable = false)
    Integer id;

    @Column(name = "model_name",nullable = false)
    String modelName;

    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    CarBrand brandId;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "modelId", fetch = FetchType.LAZY)
    Collection<Announcement> announcements;

    public CarModel(Integer id) {
        this.id = id;
    }
}
