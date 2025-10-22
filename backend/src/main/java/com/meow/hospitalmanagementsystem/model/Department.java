package com.meow.hospitalmanagementsystem.model;

import com.meow.hospitalmanagementsystem.model.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deptId;

    private String deptName;
    private String description;
    private String deptContactNumber;
    private String deptEmail;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String location;

    @OneToOne(optional = true)
    @JoinColumn(name = "head_of_department_id", referencedColumnName = "id")
    private Doctor headOfDepartment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Doctor> doctorList;


    @PrePersist
    public void onCreate(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
