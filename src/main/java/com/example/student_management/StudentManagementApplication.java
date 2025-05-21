package com.example.student_management;

import com.example.student_management.enums.Role;
import com.example.student_management.model.entity.RoleEntity;
import com.example.student_management.model.entity.UserEntity;
import com.example.student_management.repository.RoleRepository;
import com.example.student_management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository,RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			if (roleRepository.count() == 0) {
				RoleEntity adminRole = new RoleEntity();
				adminRole.setCode(Role.ADMIN.name()); // "ADMIN"
				adminRole.setName(Role.ADMIN.getName()); // "quan-tri-vien"

				RoleEntity studentRole = new RoleEntity();
				studentRole.setCode(Role.STUDENT.name()); // "STUDENT"
				studentRole.setName(Role.STUDENT.getName()); // "sinh-vien"

				roleRepository.saveAll(List.of(adminRole, studentRole));
			}
			UserEntity user = userRepository.findOneByEmail("ng.hong1904@gmail.com");
			if (user == null) {
				UserEntity admin = new UserEntity();
				admin.setEmail("ng.hong1904@gmail.com");
				admin.setPassword(passwordEncoder.encode("admin123"));
				RoleEntity roleEntity = roleRepository.findOneByCode(Role.ADMIN.name());
				admin.setRoles(Set.of(roleEntity));
				userRepository.save(admin);
			}
		};
	}
}


