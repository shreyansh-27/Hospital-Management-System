package com.meow.hospitalmanagementsystem.mapper;

import com.meow.hospitalmanagementsystem.dto.PatientAppointmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.PatientAppointmentResponseDTO;
import com.meow.hospitalmanagementsystem.model.PatientAppointment;

public class PatientAppointmentMapper {

    public static PatientAppointment toPatientAppointment(PatientAppointmentRequestDTO dto) {
        PatientAppointment patientAppointment = new PatientAppointment();

        patientAppointment.setPatientAppointmentId(dto.getPatientAppointmentId());
        patientAppointment.setAppointment(dto.getAppointmentId());
    }

    /* <<<<<<<<<<<<<<  ✨ Windsurf Command ⭐ >>>>>>>>>>>>>>>> */

    /**
     * Converts a PatientAppointment to a PatientAppointmentResponseDTO.
     *
     * @param patientAppointment The PatientAppointment to convert.
     * @return The converted PatientAppointmentResponseDTO.
     */
    /* <<<<<<<<<<  e5834ed4-1bf6-4ca9-86b1-63fb73049e46  >>>>>>>>>>> */
    public static PatientAppointmentResponseDTO toPatientAppointmentResponseDTO(PatientAppointment patientAppointment) {
        return null;
    }
}
