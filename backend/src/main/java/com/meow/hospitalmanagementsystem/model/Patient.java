package com.meow.hospitalmanagementsystem.model;

import com.meow.hospitalmanagementsystem.model.enums.BloodGroup;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends User{

    private Date admissionDate;
    private BloodGroup bloodGroup;
    private String EmergencyContactName;
    private int emergencyContactNumber;
    private String medicalHistory;
}
