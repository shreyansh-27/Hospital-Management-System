package com.meow.hospitalmanagementsystem.repo;

import com.meow.hospitalmanagementsystem.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepo extends JpaRepository<Doctor, Long> {}
