package com.example.announcementproject.models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "account_sequence",initialValue = 1,allocationSize = 1)
    @Column(name = "id", nullable = false)
    Integer id;

    @Min(value = 0)
    @Column(name = "balance",columnDefinition = "Decimal(10,2) default '0.0'")
    Double balance;

    @Column(name = "vip",columnDefinition = "boolean default 'false'")
    Boolean vip;

    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    User userId;

    public Account(Double balance){
        this.balance = balance;
    }
}
