package com.siwes.GradingSystem.controller;

import com.siwes.GradingSystem.user.Role;

public record RegistrationRequest(
        Integer id,
        String firstname,
        String lastname,
        String email,
        String password,
        String regNo,
        String dept,
        double cgpa,
        String address,
        Role role
) {

}
