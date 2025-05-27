package com.example.student_management.model.request;

import com.example.student_management.enums.Gender;
import com.example.student_management.enums.StudentStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentCreateRequest {
    private String studentCode;
    private String name;
    private String email;
    private String password;
    private String phone;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String address;
    private String major;
    private String enrolledAt;
    private StudentStatus status;
}
