package com.meow.hospitalmanagementsystem.repo;

import com.meow.hospitalmanagementsystem.model.Patient;
import com.meow.hospitalmanagementsystem.model.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    Optional<Patient> findPatientByPhoneNumber(String phoneNumber);

    Optional<Patient> findPatientByEmail(String email);

    List<Patient> findByStatus(Status status);

    Optional<Object> findByIdAndStatus(Long id, Status status);
}

