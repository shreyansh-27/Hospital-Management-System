package com.meow.hospitalmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.meow.hospitalmanagementsystem.model.enums.Role;
import com.meow.hospitalmanagementsystem.model.enums.Status;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = true)
  private String middleName;

  @Column(nullable = false)
  private String lastName;

  @Column(unique = true)
  private String username;

  @Column(unique = true, nullable = false)
  private String phoneNumber;

  @Column(unique = true)
  private String email;

  private LocalDate dateOfBirth;
  private String password;

  private String imageName;
  private String imageType;
  @JsonIgnore private byte[] imageBytes;

  @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
  @JoinColumn(name = "address_id")
  private Address address;

  @Enumerated(EnumType.STRING)
  private Role role = Role.doctor;

  @Enumerated(EnumType.STRING)
  private Status status;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  @PrePersist
  public void onCreate() {
    createdAt = LocalDateTime.now();
  }

  @PreUpdate
  public void onUpdate() {
    updatedAt = LocalDateTime.now();
  }
}
