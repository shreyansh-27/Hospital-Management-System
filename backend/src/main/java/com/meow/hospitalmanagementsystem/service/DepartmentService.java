package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.DepartmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DepartmentResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {
    ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments();

    ResponseEntity<DepartmentResponseDTO> getDepartmentById(Long id);

    ResponseEntity<DepartmentResponseDTO> createDepartment(DepartmentRequestDTO dto);

    ResponseEntity<DepartmentResponseDTO> updateDepartmentById(Long id, DepartmentRequestDTO dto);

    ResponseEntity<String> deleteDepartmentById(Long id);
}
