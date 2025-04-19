package com.example.student_management.service.impl;

import com.example.student_management.converter.request.StudentRequestConverter;
import com.example.student_management.converter.response.StudentResponseConverter;
import com.example.student_management.exception.AppException;
import com.example.student_management.exception.ErrorCode;
import com.example.student_management.model.entity.StudentEntity;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.model.request.StudentUpdateRequest;
import com.example.student_management.model.request.UpdateStatusRequest;
import com.example.student_management.model.response.StudentResponse;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.repository.UserRepository;
import com.example.student_management.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Slf4j
@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentRequestConverter studentRequestConverter;
    private final StudentResponseConverter studentResponseConverter;
    private final UserRepository userRepository;

    @Override
    public StudentResponse createStudent(StudentCreateRequest studentRequest) {
        UserEntity user = userRepository.findOneByEmail(studentRequest.getEmail());
        if (user != null) {
            throw new AppException(ErrorCode.DUPLICATE_EMAIL);
        }
        if (studentRepository.existsByStudentCode(studentRequest.getStudentCode())) {
            throw new AppException(ErrorCode.DUPLICATE_STUDENT_CODE);
        }
        return studentResponseConverter.toDto(studentRepository.save(studentRequestConverter.toEntity(studentRequest)));
    }

    @Override
    public StudentResponse getStudentByUserId(Long id) {
        StudentEntity student = studentRepository.findOneByUserId(id);
        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUNT);
        }
        return studentResponseConverter.toDto(student);
    }

    @Override
    public Page<StudentResponse> searchStudent(String keyword, Pageable pageable) {
        Page<StudentEntity> students;
        if (pageable == null || pageable.getPageNumber() < 0 || pageable.getPageSize() <= 0) {
            throw new AppException(ErrorCode.INVALID_PAGE_REQUEST);
        }
        if (StringUtils.hasText(keyword)) {
            students = studentRepository.searchStudent(keyword, pageable);
        } else {
            students = studentRepository.findAll(pageable);
        }
        return studentResponseConverter.toDTOPage(students);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentUpdateRequest request) {
        StudentEntity student = studentRepository.findOneByUserId(id);
        UserEntity user = userRepository.findOneByEmail(request.getEmail());
        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUNT);
        }
        if (user != null && !student.getUser().getEmail().equals(request.getEmail())) {
            throw new AppException(ErrorCode.DUPLICATE_EMAIL);
        }
        if (user != null){
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
        }
        student.setName(request.getName());
        student.setAddress(request.getAddress());
        student.setDateOfBirth(request.getDateOfBirth());
        student.setUser(user);
        return studentResponseConverter.toDto(studentRepository.save(student));
    }

    @Override
    public StudentResponse updateStatus(Long id, UpdateStatusRequest request) {
        StudentEntity student = studentRepository.findOneByUserId(id);
        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_FOUNT);
        }
        student.setStatus(request.getStatus());
        return studentResponseConverter.toDto(studentRepository.save(student));
    }
}
