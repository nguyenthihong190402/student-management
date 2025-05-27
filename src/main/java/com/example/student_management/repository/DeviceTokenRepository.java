package com.example.student_management.repository;

import com.example.student_management.model.entity.DeviceTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceTokenRepository extends JpaRepository<DeviceTokenEntity,Long> {
   DeviceTokenEntity findByTokenAndUser_Id(String token,Long userId);
}
