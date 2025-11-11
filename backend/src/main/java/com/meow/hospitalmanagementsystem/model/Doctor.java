package com.meow.hospitalmanagementsystem.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends User {

    @Column(unique = true, nullable = false)
    private String medicalLicense;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id")
    private Department department;

    @OneToOne(mappedBy = "headOfDepartment")
    private Department departmentHeaded;

    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    private String specialization;
    private String qualification;
    private double consultationFees;
    private int experience;
    private String daysAvailable;
    private LocalTime fromTimeAvailable;
    private LocalTime toTimeAvailable;

    @OneToMany(mappedBy = "doctor")
    private List<DoctorAppointment> doctorAppointments;
}