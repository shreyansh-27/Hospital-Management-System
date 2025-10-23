package com.meow.hospitalmanagementsystem.model;

import com.meow.hospitalmanagementsystem.model.enums.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends User{

    private LocalDateTime admissionDate;
    private BloodGroup bloodGroup;
    private String emergencyContactName;
    private int emergencyContactNumber;
    private String medicalHistory;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PatientAppointment> patientAppointments;

}
