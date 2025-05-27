package com.example.student_management.repository;

import com.example.student_management.model.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    boolean existsByStudentCode(String studentCode);

    StudentEntity findOneByUserId(Long id);

    @Query("SELECT s FROM StudentEntity s JOIN s.user u WHERE " +
            "LOWER(s.name) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(u.email) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<StudentEntity> searchStudent(@Param("keyword") String keyword, Pageable pageable);
}
