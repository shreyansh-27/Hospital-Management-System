package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.DoctorAppointmentRequestDTO;

import java.util.ArrayList;
import java.util.List;

public class DoctorAppointmentMapper {

    public static List<DoctorAppointmentRequestDTO> doctorAppointmentRequestDTOS(List<Long> ids) {

        List<DoctorAppointmentRequestDTO> doctorAppointmentRequestDTOS = new ArrayList<>();

        if (ids != null && !ids.isEmpty()) {
            doctorAppointmentRequestDTOS = ids.stream().map(id -> {
                DoctorAppointmentRequestDTO dto = new DoctorAppointmentRequestDTO();
                dto.setDoctorAppointmentId(id);
                return dto;
            }).toList();
        }
        return doctorAppointmentRequestDTOS;
    }
}
