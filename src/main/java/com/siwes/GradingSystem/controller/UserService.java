
package com.siwes.GradingSystem.controller;

import com.siwes.GradingSystem.user.Role;
import com.siwes.GradingSystem.user.UserRepository;
import com.siwes.GradingSystem.user.Users;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void create(RegistrationRequest request) {

        var user = Users.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(request.password())
                .regNo(request.regNo())
                .dept(request.dept())
                .cgpa(request.cgpa())
                .address(request.address())
                .role(Role.STUDENT)
                .build();

        repository.save(user);
    }

    public List<UserResponse> getAllUser() {

        List<Users> users = repository.findAll();

        if (users.isEmpty()) {
            throw new RuntimeException("No records found");
        }

        return users.stream()
                .map(this::toResponse)
                .toList();
    }


    public UserResponse getUser(Integer id) {

        Users user = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return toResponse(user);
    }

    public void update(RegistrationRequest request, Integer id) {

        Users user = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        user.setFirstname(request.firstname());
        user.setLastname(request.lastname());
        user.setEmail(request.email());
        user.setRegNo(request.regNo());
        user.setDept(request.dept());
        user.setCgpa(request.cgpa());
        user.setAddress(request.address());

        repository.save(user);
    }

    public void delete(Integer id) {

        Users user = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        repository.delete(user);
    }


    public UserResponse toResponse(Users user) {

        return UserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .regNo(user.getRegNo())
                .dept(user.getDept())
                .cgpa(user.getCgpa())
                .address(user.getAddress())
                .createdAt(user.getCreatedAt())
                .role(user.getRole())
                .build();
    }
}
