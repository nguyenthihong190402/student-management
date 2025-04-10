package com.example.student_management.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class StudentResponse extends BaseResponse {
    private String studentCode;
    private String name;
    private String email;
    private String phone;
    private String dateOfBirth;
    private String gender;
    private String address;
    private String major;
    private String enrolledAt;
    private String status;
}
