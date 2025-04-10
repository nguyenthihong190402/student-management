package com.example.student_management.service;

import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentResponse createStudent(StudentRequest studentRequest);
    StudentResponse getStudentById(Long id);
    Page<StudentResponse> searchStudent(String keyword, Pageable pageable);
}
