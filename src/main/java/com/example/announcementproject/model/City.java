package com.example.announcementproject.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "city_name", nullable = false, unique = true)
    String cityName;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "cityId")
    Collection<User> userCollection;

    public City(Integer id) {
        this.id = id;
    }

    public City(Integer i, String cityName) {
        this.id = i;
        this.cityName = cityName;
    }
}
