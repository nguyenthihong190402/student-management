package com.example.student_management.model.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StudentUpdateRequest {
    private String name;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;
    private String address;
}
