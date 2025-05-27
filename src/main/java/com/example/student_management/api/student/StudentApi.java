package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

public interface StudentApi {
    default StudentApiDelegate getDelegate() {
        return new StudentApiDelegate() {
        };
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping
    default ResponseEntity<StudentResponse> createStudent(@RequestBody() StudentCreateRequest request) {
        return this.getDelegate().createStudent(request);
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/{id}")
    default ResponseEntity<StudentResponse> getStudentById(@Valid @PathVariable(value = "id") Long id) {
        return this.getDelegate().getStudentById(id);
    }

    @GetMapping("/search")
    default ResponseEntity<Page<StudentResponse>> searchStudent(@RequestParam(required = false) String keyword, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize) {
        return this.getDelegate().searchStudent(keyword, pageNumber, pageSize);
    }

    @PutMapping("/{id}")
    default ResponseEntity<StudentResponse> updateStudent(@PathVariable(value = "id") Long id,@RequestBody StudentUpdateRequest request) {
        return this.getDelegate().updateStudent(id,request);
    }

    @PatchMapping("/{id}")
    default ResponseEntity<StudentResponse> updateStatusStudent(@PathVariable(value = "id") Long id, @RequestBody UpdateStatusRequest request) {
        return this.getDelegate().updateStatusStudent(id, request);
    }

    @GetMapping("/token")
    default ResponseEntity<StudentResponse> getUserByToken() {
        return this.getDelegate().getUserByToken();
    }

}
