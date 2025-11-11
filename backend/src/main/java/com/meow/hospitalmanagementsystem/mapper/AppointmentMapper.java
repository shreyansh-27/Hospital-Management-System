package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.AppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.AppointmentResponseDTO;
import com.meow.hospitalmanagementsystem.model.*;
import com.meow.hospitalmanagementsystem.model.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class AppointmentMapper {

    public static Appointment toAppointment(AppointmentRequestDTO dto) {
        Appointment appointment = new Appointment();
        appointment.setAppointmentId(dto.getAppointmentId());

        appointment.setAppointmentDate(dto.getAppointmentDateTime());
        appointment.setStatus(Status.valueOf(dto.getAppointmentStatus()));

        List<PatientAppointment> patientAppointments = new ArrayList<>();
        if (dto.getPatientIds() != null && !dto.getPatientIds().isEmpty()) {

            for (Long id : dto.getPatientIds()) {
                PatientAppointment pa = new PatientAppointment();

                Patient patient = new Patient();
                patient.setId(id);

                pa.setAppointment(appointment);
                pa.setPatient(patient);
                patientAppointments.add(pa);
            }
        }

        appointment.setPatientAppointments(patientAppointments);

        List<DoctorAppointment> doctorAppointments = new ArrayList<>();
        if (dto.getDoctorIds() != null && !dto.getDoctorIds().isEmpty()) {
            for (Long doctorId : dto.getDoctorIds()) {
                DoctorAppointment da = new DoctorAppointment();
                Doctor doctor = new Doctor();

                da.setDoctor(doctor);
                da.setAppointment(appointment);

                doctorAppointments.add(da);
            }
        }


        appointment.setDoctorAppointments(doctorAppointments);


        return appointment;
    }

    public static AppointmentResponseDTO toAppointmentResponseDTO(Appointment appointment) {
        List<Long> patientIds = new ArrayList<>();
        List<Long> doctorIds = new ArrayList<>();

        patientIds = appointment.getPatientAppointments().stream().map(pa -> {
            return pa.getPatient().getId();
        }).toList();

        doctorIds = appointment.getDoctorAppointments().stream().map(DoctorAppointment::getId).toList();

        return new AppointmentResponseDTO(
                appointment.getAppointmentId(),
                patientIds,
                doctorIds,
                appointment.getAppointmentDate(),
                appointment.getStatus().toString());
    }

}
