package com.example.student_management.converter.response;

import com.example.student_management.converter.BaseConverter;
import com.example.student_management.model.entity.StudentEntity;
import com.example.student_management.model.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentResponseConverter extends BaseConverter<StudentEntity, StudentResponse> {
    @Override
    public StudentResponse toDto(StudentEntity student) {
        StudentResponse response = super.toDto(student);
        response.setAddress(student.getAddress());
        response.setEmail(student.getUser().getEmail());
        response.setMajor(student.getMajor());
        response.setGender(student.getGender() != null ? student.getGender().name() : null);
        response.setName(student.getName());
        response.setPhone(student.getUser().getPhone());
        response.setStatus(student.getStatus() != null ? student.getStatus().name(): null);
        response.setStudentCode(student.getStudentCode());
        response.setDateOfBirth(student.getDateOfBirth().toString());
        response.setEnrolledAt(student.getEnrolledAt());
        return response;
    }
}
