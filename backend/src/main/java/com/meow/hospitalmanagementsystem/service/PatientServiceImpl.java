package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.meow.hospitalmanagementsystem.exception.InvalidRequestException;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.PatientMapper;
import com.meow.hospitalmanagementsystem.model.Patient;
import com.meow.hospitalmanagementsystem.model.enums.Status;
import com.meow.hospitalmanagementsystem.repo.PatientRepo;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;

    PatientServiceImpl(PatientRepo patientRepo) {
        this.patientRepo = patientRepo;
    }

    @Override
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients() {

        List<PatientResponseDTO> patientResponseDTOS = patientRepo.findByStatus(Status.ACTIVE)
                .stream()
                .map(PatientMapper::toPatientResponse)
                .toList();

        if (patientResponseDTOS.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(patientResponseDTOS);
    }

    @Override
    public ResponseEntity<PatientResponseDTO> getPatientById(Long patientId) {
        Patient patient = (Patient) patientRepo.findByIdAndStatus(patientId, Status.ACTIVE)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", patientId));

        return new ResponseEntity<>(PatientMapper.toPatientResponse(patient), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PatientResponseDTO> addPatient(PatientRequestDTO patientDTO) {
        Patient patient = PatientMapper.toPatient(patientDTO);

        boolean exists =
                patientRepo.findPatientByPhoneNumber(patient.getPhoneNumber()).isPresent() ||
                        patientRepo.findPatientByEmail(patient.getEmail()).isPresent();

        if (exists) {
            throw new InvalidRequestException("Patient already exists");
        }
        System.out.println(patient);
        patient.setStatus(Status.ACTIVE);

        Patient newPatient = patientRepo.save(patient);
        return new ResponseEntity<>(PatientMapper.toPatientResponse(newPatient), HttpStatus.CREATED);

    }

    @Override
    public ResponseEntity<PatientResponseDTO> updatePatient(PatientRequestDTO patientRequestDTO, Long id) {

        Patient patient = (Patient) patientRepo.findByIdAndStatus(id, Status.ACTIVE).
                orElseThrow(() -> new ResourceNotFoundException("Patient", id));

        patient = PatientMapper.toPatient(patientRequestDTO);

        Patient updatedPatient = patientRepo.save(patient);
        return ResponseEntity.ok(PatientMapper.toPatientResponse(updatedPatient));
    }

    @Override
    public ResponseEntity<String> deletePatient(Long patientId) {
        Patient patient = patientRepo
                .findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", patientId));
        if (patient.getStatus() == Status.INACTIVE) {
            throw new InvalidRequestException("Patient is already inactive");
        }

        patient.setStatus(Status.INACTIVE);
        patientRepo.save(patient);
        return ResponseEntity.ok("Patient Deleted Successfully");
    }

    @Override
    public ResponseEntity<byte[]> getImageByPatientId(Long patientId) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", patientId));

        byte[] imageBytes = patient.getImageBytes();

        if (imageBytes == null || imageBytes.length == 0) {
            throw new ResourceNotFoundException("Image not found for patient", patientId);
        }

        MediaType imageType = MediaType.valueOf(patient.getImageType());

        return ResponseEntity.ok()
                .header(HttpHeaders.CACHE_CONTROL, "max-age=3600") //allow browser to cache image for an hour
                .contentType(imageType)
                .body(patient.getImageBytes());
    }

    @Override
    public ResponseEntity<String> addOrUploadImage(MultipartFile file, Long patientId) throws IOException {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new ResourceNotFoundException("Patient", patientId));

        if (file.isEmpty()) throw new IllegalArgumentException("uploaded file is empty");

        patient.setImageName(file.getOriginalFilename());
        patient.setImageType(file.getContentType());
        patient.setImageBytes(file.getBytes());

        patientRepo.save(patient);
        return new ResponseEntity<>("Image successfully uploaded", HttpStatus.CREATED);
    }

}
