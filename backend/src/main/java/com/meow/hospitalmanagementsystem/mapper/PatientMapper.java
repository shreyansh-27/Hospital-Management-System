package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.PatientRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientResponseDTO;
import com.meow.hospitalmanagementsystem.model.Patient;
import com.meow.hospitalmanagementsystem.model.enums.BloodGroup;

public class PatientMapper {
    public static Patient toPatient(PatientRequestDTO patientDTO) {

        Patient patient = new Patient();

        patient.setFirstName(patientDTO.getFirstName());
        patient.setMiddleName(patientDTO.getMiddleName());
        patient.setLastName(patientDTO.getLastName());
        patient.setEmail(patientDTO.getEmail());
        patient.setPhoneNumber(patientDTO.getPhone());
        patient.setBloodGroup(BloodGroup.valueOf(patientDTO.getBloodGroup()));
        patient.setAddress(AddressMapper.toAddress(patientDTO.getAddressDTO()));
        patient.setEmergencyContactName(patientDTO.getEmergencyContactName());
        patient.setEmergencyContactNumber(patientDTO.getEmergencyContactNumber());
        patient.setMedicalHistory(patientDTO.getMedicalHistory());
        return patient;
    }

    public static PatientResponseDTO toPatientResponse(Patient patient) {
        return new PatientResponseDTO(
                patient.getId(),
                patient.getFirstName(),
                patient.getMiddleName(),
                patient.getLastName(),
                patient.getEmail(),
                patient.getPhoneNumber(),
                patient.getBloodGroup().toString(),
                AddressMapper.toAddressResponseDTO(patient.getAddress())
        );
    }

}
