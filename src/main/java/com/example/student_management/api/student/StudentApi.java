package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface StudentApi {
    default StudentApiDelegate getDelegate() {
        return new StudentApiDelegate() {
        };
    }

    @RequestMapping(
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    default ResponseEntity<StudentResponse> createStudent(@RequestBody() StudentRequest request) {
        return this.getDelegate().createStudent(request);
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            produces = {"application/json"},
            path = "/{id}"
    )
    default ResponseEntity<StudentResponse> getStudentById(@Valid @PathVariable(value = "id") Long id) {
        return this.getDelegate().getStudentById(id);
    }

    @RequestMapping(
            method = {RequestMethod.GET},
            produces = {"application/json"},
            path = "/search"
    )
    default ResponseEntity<Page<StudentResponse>> searchStudent(@RequestParam(required = false) String keyword, @RequestParam(value = "pageNumber") Integer pageNumber, @RequestParam(value = "pageSize") Integer pageSize) {
        return this.getDelegate().searchStudent(keyword, pageNumber, pageSize);
    }
}
