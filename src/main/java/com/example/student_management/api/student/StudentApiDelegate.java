package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface StudentApiDelegate {
    default ResponseEntity<StudentResponse> createStudent(StudentCreateRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    default ResponseEntity<StudentResponse> getStudentById(Long id) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    default ResponseEntity<Page<StudentResponse>> searchStudent(String keyword, Integer pageNumber, Integer pageSize) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    default ResponseEntity<StudentResponse> updateStudent(Long userId, StudentUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    default ResponseEntity<StudentResponse> updateStatusStudent(Long id, UpdateStatusRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }

    default ResponseEntity<StudentResponse> getUserByToken() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
    }
}
