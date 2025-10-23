package com.meow.hospitalmanagementsystem.model;

import com.meow.hospitalmanagementsystem.model.enums.BillType;
import com.meow.hospitalmanagementsystem.model.enums.PaymentMode;
import com.meow.hospitalmanagementsystem.model.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billId;

    @ManyToOne
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointmentId")
    private Appointment appointment;

    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @Enumerated(EnumType.STRING)
    private BillType billType;

    private String generatedBy;

    private double totalAmount;

    @OneToMany(mappedBy = "bill", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Payment> payments;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    private LocalDateTime dateOfIssue;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate(){
        dateOfIssue = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate(){
        updatedAt = LocalDateTime.now();
    }

}
