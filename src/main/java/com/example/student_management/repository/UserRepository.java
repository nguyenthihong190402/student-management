package com.example.student_management.repository;

import com.example.student_management.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByEmail(String email);
    UserEntity findOneById(Long id);
}
