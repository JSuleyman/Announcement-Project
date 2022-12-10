package com.example.announcementproject.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Collection;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @Column(name = "user_name", nullable = false)
    String name;

    @Email
    @Column(name = "email", nullable = false)
    String email;

    @Column(name = "user_password", nullable = false)
    String password;

    @Column(name = "phone_number", nullable = false)
    String phoneNumber;

    @JoinColumn(name = "city_id", referencedColumnName = "id", nullable = false)
    @ManyToOne
    City cityId;

    @OneToOne(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "userId", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    Account account;

    @Getter(AccessLevel.NONE)
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "user", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    Collection<Announcement> announcements;

    public User(Integer id) {
        this.id = id;
    }
}
