package com.example.student_management.api.student;

import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface StudentApi {
    default StudentApiDelegate getDelegate(){
        return new StudentApiDelegate(){};
    }

    @RequestMapping(
            method = {RequestMethod.POST},
            produces = {"application/json"}
    )
    default ResponseEntity<StudentResponse> createStudent(@RequestBody() StudentRequest request) {
        return this.getDelegate().createStudent(request);
    }
}
