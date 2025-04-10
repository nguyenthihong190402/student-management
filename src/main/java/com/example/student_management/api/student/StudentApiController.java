package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
@Slf4j
public class StudentApiController implements StudentApi {
    private final StudentApiDelegate delegate;

    @Override
    public ResponseEntity<StudentResponse> createStudent(StudentRequest request) {
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
}
