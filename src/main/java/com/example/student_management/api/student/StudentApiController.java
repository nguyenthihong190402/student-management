package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth/students")
@RequiredArgsConstructor
@Slf4j
public class StudentApiController implements StudentApi {
    private final StudentApiDelegate delegate;

    @Override
    public ResponseEntity<StudentResponse> createStudent(StudentCreateRequest request) {
        return delegate.createStudent(request);
    }

    @Override
    public ResponseEntity<StudentResponse> getStudentById(Long id) {
        return delegate.getStudentById(id);
    }

    @Override
    public ResponseEntity<Page<StudentResponse>> searchStudent(String keyword, Integer pageNumber, Integer pageSize) {
        return delegate.searchStudent(keyword, pageNumber, pageSize);
    }

    @Override
    public ResponseEntity<StudentResponse> updateStudent(Long userId, StudentUpdateRequest request) {
        return delegate.updateStudent(userId, request);
    }

    @Override
    public ResponseEntity<StudentResponse> updateStatusStudent(Long id, UpdateStatusRequest request) {
        return delegate.updateStatusStudent(id, request);
    }

    @Override
    public ResponseEntity<StudentResponse> getUserByToken() {
        return delegate.getUserByToken();
    }
}
