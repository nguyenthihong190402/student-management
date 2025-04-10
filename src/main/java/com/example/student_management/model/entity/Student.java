package com.example.student_management.model.entity;

import com.example.student_management.enums.Gender;
import com.example.student_management.enums.StudentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student extends BaseEntity {
    @Column(unique = true)
    private String studentCode;
    private String name;
    @Column(unique = true)
    private String email;
    private String phone;
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;
    private String major;
    private String enrolledAt;

    @Enumerated(EnumType.STRING)
    private StudentStatus status;
}
