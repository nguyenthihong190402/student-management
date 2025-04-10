package com.example.student_management.delegate;

import com.example.student_management.api.student.StudentApiDelegate;
import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
public class StudentApiDelegateImpl implements StudentApiDelegate {
    private final StudentService studentService;

    @Override
    public ResponseEntity<StudentResponse> createStudent(StudentRequest studentRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(studentRequest));
    }
}
