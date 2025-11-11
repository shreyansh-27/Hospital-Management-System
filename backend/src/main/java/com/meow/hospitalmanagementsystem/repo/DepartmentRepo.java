package com.meow.hospitalmanagementsystem.repo;

import com.meow.hospitalmanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
    boolean existsByDepartmentName(String departmentName);
}
