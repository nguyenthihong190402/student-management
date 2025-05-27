package com.example.student_management.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserResponse extends BaseResponse{
    private String email;
    private String phone;
}
