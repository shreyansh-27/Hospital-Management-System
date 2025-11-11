package com.meow.hospitalmanagementsystem.repo;

import com.meow.hospitalmanagementsystem.model.PatientAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientAppointmentRepository extends JpaRepository<PatientAppointment, Long> {
}
