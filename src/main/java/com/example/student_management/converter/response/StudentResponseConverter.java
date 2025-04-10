package com.example.student_management.converter.response;

import com.example.student_management.converter.BaseConverter;
import com.example.student_management.model.entity.Student;
import com.example.student_management.model.response.StudentResponse;
import org.springframework.stereotype.Component;

@Component
public class StudentResponseConverter extends BaseConverter<Student, StudentResponse> {
    @Override
    public StudentResponse toDto(Student student) {
        StudentResponse response = super.toDto(student);
        response.setAddress(student.getAddress());
        response.setEmail(student.getEmail());
        response.setMajor(student.getMajor());
        response.setGender(student.getGender() != null ? student.getGender().name() : null);
        response.setName(student.getName());
        response.setPhone(student.getPhone());
        response.setStatus(student.getStatus() != null ? student.getStatus().name(): null);
        response.setStudentCode(student.getStudentCode());
        response.setDateOfBirth(student.getDateOfBirth().toString());
        response.setEnrolledAt(student.getEnrolledAt());
        return response;
    }
}
