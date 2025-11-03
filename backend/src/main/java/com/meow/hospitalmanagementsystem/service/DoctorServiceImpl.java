package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.DoctorRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DoctorResponseDTO;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.DoctorMapper;
import com.meow.hospitalmanagementsystem.model.Doctor;
import com.meow.hospitalmanagementsystem.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public ResponseEntity<List<DoctorResponseDTO>> getAllDoctors() {
        List<DoctorResponseDTO> doctorResponseDTOList =
                doctorRepo.findAll().stream().map(DoctorMapper::toDoctorDto).toList();

        if (doctorResponseDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctorResponseDTOList);
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> getDoctorById(Long id) {
        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", id));


        return null;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> saveDoctor(DoctorRequestDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> updateDoctorById(Long id, DoctorRequestDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteDoctorById(Long id) {
        return null;
    }
}
