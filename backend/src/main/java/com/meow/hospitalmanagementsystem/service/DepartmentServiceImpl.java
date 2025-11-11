package com.meow.hospitalmanagementsystem.service;

import com.meow.hospitalmanagementsystem.dto.DepartmentRequestDTO;
import com.meow.hospitalmanagementsystem.dto.DepartmentResponseDTO;
import com.meow.hospitalmanagementsystem.exception.InvalidRequestException;
import com.meow.hospitalmanagementsystem.exception.ResourceNotFoundException;
import com.meow.hospitalmanagementsystem.mapper.DepartmentMapper;
import com.meow.hospitalmanagementsystem.model.Department;
import com.meow.hospitalmanagementsystem.repo.DepartmentRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    @Override
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {

        boolean exists = departmentRepo.findAll().isEmpty();

        if (!exists) {
            throw new ResourceNotFoundException("Department", "List empty");
        }

        List<DepartmentResponseDTO> departmentResponseDTOList = departmentRepo.findAll().stream().map(DepartmentMapper::toDepartmentResponseDTO).toList();
        return ResponseEntity.ok(departmentResponseDTOList);
    }

    @Override
    public ResponseEntity<DepartmentResponseDTO> getDepartmentById(Long id) {

        Department department = departmentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Department", id));

        return ResponseEntity.ok(DepartmentMapper.toDepartmentResponseDTO(department));
    }

    @Override
    public ResponseEntity<DepartmentResponseDTO> createDepartment(DepartmentRequestDTO dto) {

        boolean exists = departmentRepo.existsById(dto.getId()) || departmentRepo.existsByDepartmentName(dto.getDepartmentName());

        if (exists) {
            throw new InvalidRequestException("Department already exists");
        }

        Department department = DepartmentMapper.toDepartment(dto);
        Department savedDepartment = departmentRepo.save(department);
        return ResponseEntity.ok(DepartmentMapper.toDepartmentResponseDTO(savedDepartment));
    }

    @Override
    public ResponseEntity<DepartmentResponseDTO> updateDepartmentById(Long id, DepartmentRequestDTO dto) {

        Department department = departmentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", id));

        Department savedDepartment = departmentRepo.save(DepartmentMapper.toDepartment(dto));
        return ResponseEntity.ok(DepartmentMapper.toDepartmentResponseDTO(savedDepartment));
    }

    @Override
    public ResponseEntity<String> deleteDepartmentById(Long id) {

        boolean exists = departmentRepo.existsById(id);

        if (!exists) {
            throw new ResourceNotFoundException("Department", id);
        }

        departmentRepo.deleteById(id);
        return ResponseEntity.ok("Department deleted!");
    }
}
