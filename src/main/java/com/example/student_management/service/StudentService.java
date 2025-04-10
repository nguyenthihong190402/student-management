package com.example.student_management.service;

import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;

public interface StudentService {
    StudentResponse createStudent(StudentRequest studentRequest);
}
