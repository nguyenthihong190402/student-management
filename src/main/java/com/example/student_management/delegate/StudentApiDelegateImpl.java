package com.example.student_management.delegate;

import com.example.student_management.api.student.StudentApiDelegate;
import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StudentApiDelegateImpl implements StudentApiDelegate {
    private final StudentService studentService;

    @Override
    public ResponseEntity<StudentResponse> createStudent(StudentCreateRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentRequest));
    }

    @Override
    public ResponseEntity<StudentResponse> getStudentById(Long id) {
        return ResponseEntity.ok(studentService.getStudentByUserId(id));
    }

    @Override
    public ResponseEntity<Page<StudentResponse>> searchStudent(String keyword, Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return ResponseEntity.ok(studentService.searchStudent(keyword, pageable));
    }

    @Override
    public ResponseEntity<StudentResponse> updateStudent(Long id, StudentUpdateRequest request) {
        return ResponseEntity.ok(studentService.updateStudent(id,request));
    }

    @Override
    public ResponseEntity<StudentResponse> updateStatusStudent(Long id, UpdateStatusRequest request) {
        return ResponseEntity.ok(studentService.updateStatus(id, request));
    }
}
