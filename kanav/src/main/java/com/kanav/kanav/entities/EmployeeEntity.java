package com.kanav.kanav.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class EmployeeEntity {

@Id()
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private LocalDate dateOfJoining;



    private boolean isActive;
}
