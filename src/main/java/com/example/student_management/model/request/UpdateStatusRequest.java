package com.example.student_management.model.request;

import com.example.student_management.enums.StudentStatus;
import lombok.Data;

@Data
public class UpdateStatusRequest{
    private StudentStatus status;
}
