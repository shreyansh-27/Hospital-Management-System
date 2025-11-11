package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.DoctorRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DoctorResponseDTO;
import com.meow.hospitalmanagementsystem.exception.InvalidRequestException;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.DoctorMapper;
import com.meow.hospitalmanagementsystem.model.Doctor;
import com.meow.hospitalmanagementsystem.repo.DoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
                doctorRepo.findAll().stream().map(DoctorMapper::toDoctorResponseDTO).toList();

        if (doctorResponseDTOList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(doctorResponseDTOList);
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> getDoctorById(Long id) {
        Doctor doctor = doctorRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor", id));

        return ResponseEntity.ok(DoctorMapper.toDoctorResponseDTO(doctor));

    }

    @Override
    public ResponseEntity<DoctorResponseDTO> saveDoctor(DoctorRequestDTO dto) {
        boolean exist = doctorRepo.findDoctorByMedicalLicense(dto.getMedicalLicense()) != null;

        if (exist) {
            throw new InvalidRequestException("Already exists!");
        }
        Doctor doctor = DoctorMapper.toDoctor(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(DoctorMapper.toDoctorResponseDTO(doctorRepo.save(doctor)));
    }

    @Override
    public ResponseEntity<DoctorResponseDTO> updateDoctorById(Long id, DoctorRequestDTO dto) {
        Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Doctor", id));
        doctor = DoctorMapper.toDoctor(dto);

        return ResponseEntity.ok(DoctorMapper.toDoctorResponseDTO(doctorRepo.save(doctor)));
    }

    @Override
    public ResponseEntity<String> deleteDoctorById(Long id) {
        boolean exist = doctorRepo.existsById(id);

        if (exist) {
            throw new InvalidRequestException("Doctor with id " + id + "doesn't exist");
        }

        doctorRepo.deleteById(id);
        return ResponseEntity.ok("Doctor deleted!");
    }
}
