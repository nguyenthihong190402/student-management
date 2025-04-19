package com.example.student_management.service;

import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentResponse createStudent(StudentCreateRequest studentRequest);
    StudentResponse getStudentByUserId(Long id);
    Page<StudentResponse> searchStudent(String keyword, Pageable pageable);
    StudentResponse updateStudent(Long id, StudentUpdateRequest request);
    StudentResponse updateStatus(Long id, UpdateStatusRequest request);
}
