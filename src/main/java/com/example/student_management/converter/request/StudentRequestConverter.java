package com.example.student_management.converter.request;

import com.example.student_management.converter.BaseConverter;
import com.example.student_management.model.entity.Student;
import com.example.student_management.model.request.StudentRequest;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestConverter extends BaseConverter<Student, StudentRequest> {
    @Override
    public Student toEntity(StudentRequest studentRequest) {
        Student student = super.toEntity(studentRequest);
        student.setStudentCode(studentRequest.getStudentCode());
        student.setEmail(studentRequest.getEmail());
        student.setAddress(studentRequest.getAddress());
        student.setMajor(studentRequest.getMajor());
        student.setName(studentRequest.getName());
        student.setPhone(studentRequest.getPhone());
        if(studentRequest.getDateOfBirth() != null){
            student.setDateOfBirth(studentRequest.getDateOfBirth());
        }
        if (studentRequest.getEnrolledAt()!= null){
            student.setEnrolledAt(studentRequest.getEnrolledAt());
        }
        if(studentRequest.getGender() != null){
            student.setGender(studentRequest.getGender());
        }
        if(studentRequest.getStatus() != null){
            student.setStatus(studentRequest.getStatus());
        }
        return student;
    }
}
