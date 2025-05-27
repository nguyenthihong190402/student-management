package com.example.student_management.enums;

public enum Role {
    ADMIN("quan-tri-vien"), STUDENT("sinh-vien");
    private final String role;

    Role(String name) {
        this.role = name;
    }

    public String getName() {
        return role;
    }
}
