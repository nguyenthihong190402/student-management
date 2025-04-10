package com.example.student_management.service.impl;

import com.example.student_management.converter.request.StudentRequestConverter;
import com.example.student_management.converter.response.StudentResponseConverter;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.request.StudentRequest;
import com.example.student_management.model.response.StudentResponse;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentRequestConverter studentRequestConverter;
    private final StudentResponseConverter studentResponseConverter;

    @Override
    public StudentResponse createStudent(StudentRequest studentRequest) {
        if (studentRepository.existsByEmail(studentRequest.getEmail())) {
            throw new AppException(ErrorCode.DUPLICATE_EMAIL);
        }
        if (studentRepository.existsByStudentCode(studentRequest.getStudentCode())) {
            throw new AppException(ErrorCode.DUPLICATE_STUDENT_CODE);
        }
        return studentResponseConverter.toDto(studentRepository.save(studentRequestConverter.toEntity(studentRequest)));
    }
}
