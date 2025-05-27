package com.example.student_management.model.entity;

import com.example.student_management.enums.Gender;
import com.example.student_management.enums.StudentStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "students")
public class StudentEntity extends BaseEntity {
    @Column(unique = true)
    private String studentCode;
    private String name;
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String address;
    private String major;
    private String enrolledAt;
    @Enumerated(EnumType.STRING)
    private StudentStatus status;
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private UserEntity user;
}
