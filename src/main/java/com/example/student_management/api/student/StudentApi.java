package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    default ResponseEntity<StudentResponse> createStudent(@RequestBody() StudentCreateRequest request) {
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

    @RequestMapping(
            method = {RequestMethod.PUT},
            produces = {"application/json"},
            path = "/{id}"
    )
    default ResponseEntity<StudentResponse> updateStudent(@PathVariable(value = "id") Long id,@RequestBody StudentUpdateRequest request) {
        return this.getDelegate().updateStudent(id,request);
    }
    @RequestMapping(
            method = {RequestMethod.PATCH},
            produces = {"application/json"},
            path = "/{id}"
    )
    default ResponseEntity<StudentResponse> updateStatusStudent(@PathVariable(value = "id") Long id,@RequestBody UpdateStatusRequest request) {
        return this.getDelegate().updateStatusStudent(id,request);
    }

}
