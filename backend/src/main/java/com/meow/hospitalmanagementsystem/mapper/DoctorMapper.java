package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.DoctorAppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DoctorRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DoctorResponseDTO;
import com.meow.hospitalmanagementsystem.model.Doctor;
import com.meow.hospitalmanagementsystem.model.DoctorAppointment;

import java.util.List;

public class DoctorMapper {
    public static DoctorResponseDTO toDoctorResponseDTO(Doctor doctor) {
        return null;
    }

    public static Doctor toDoctor(DoctorRequestDTO dto) {
        Doctor doctor = new Doctor();
        doctor.setFirstName(dto.getFirstName());
        doctor.setLastName(dto.getLastName());
        doctor.setSpecialization(dto.getSpecialization());
        doctor.setExperience(dto.getExperience());
        doctor.setQualification(dto.getQualification());
        doctor.setAddress(AddressMapper.toAddress(dto.getAddress()));
        doctor.setPhoneNumber(dto.getPhone());
        doctor.setDoctorAppointments(
                toDoctorAppointments(
                        DoctorAppointmentMapper.
                                doctorAppointmentRequestDTOS(dto.getDoctorAppointments())));
        return doctor;
    }

    public static List<DoctorAppointment> toDoctorAppointments(List<DoctorAppointmentRequestDTO> dto) {
        return dto.stream().map(DoctorMapper::toDoctorAppointment).toList();
    }

    public static DoctorAppointment toDoctorAppointment(DoctorAppointmentRequestDTO dto) {
        DoctorAppointment doctorAppointment = new DoctorAppointment();
        doctorAppointment.setId(dto.getDoctorAppointmentId());
        return doctorAppointment;
    }

}
