package com.example.student_management.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private StudentEntity student;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", nullable = false), inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
    private Set<RoleEntity> roles = new HashSet<>();
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<DeviceTokenEntity> deviceTokens = new HashSet<>();
}
