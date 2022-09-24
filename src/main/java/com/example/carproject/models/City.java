package com.example.carproject.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "city")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_sequence")
    @SequenceGenerator(name = "city_sequence", allocationSize = 1, initialValue = 1)
    @Column(name = "id")
    Integer id;

    @Column(name = "city_name", nullable = false)
    String cityName;

    @OneToMany(mappedBy = "cityId", fetch = FetchType.LAZY)
    private Collection<User> userCollection;


    public City(Integer id) {
        this.id = id;
    }
}
