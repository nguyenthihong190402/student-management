package com.example.student_management.model.response;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class BaseResponse {
    private Long id;
}
