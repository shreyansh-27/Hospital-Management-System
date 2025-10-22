package com.meow.hospitalmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false)
    private String addressLine1;

    @Column(nullable = true)
    private String addressLine2;

    private String city;
    private String state;
    private String country;
    private int pincode;

    @OneToOne(mappedBy = "address")
    private User user;


}
