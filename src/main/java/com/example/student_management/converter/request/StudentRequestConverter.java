package com.example.student_management.converter.request;

import com.example.student_management.converter.BaseConverter;
import com.example.student_management.enums.Role;
import com.example.student_management.model.entity.RoleEntity;
import com.example.student_management.model.entity.StudentEntity;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.model.request.StudentCreateRequest;
import com.example.student_management.repository.RoleRepository;
import com.example.student_management.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class StudentRequestConverter extends BaseConverter<StudentEntity, StudentCreateRequest> {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    @Override
    public StudentEntity toEntity(StudentCreateRequest studentRequest) {
        StudentEntity student = super.toEntity(studentRequest);
        UserEntity user = new UserEntity();
        user.setEmail(studentRequest.getEmail());
        user.setPhone(studentRequest.getPhone());
        user.setPassword(passwordEncoder.encode(studentRequest.getPassword()));
        RoleEntity roleEntity = roleRepository.findOneByCode(Role.STUDENT.name());
        user.setRoles(Set.of(roleEntity));
        userRepository.save(user);

        student.setStudentCode(studentRequest.getStudentCode());
        student.setAddress(studentRequest.getAddress());
        student.setMajor(studentRequest.getMajor());
        student.setName(studentRequest.getName());
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
        student.setUser(user);
        return student;
    }
}
