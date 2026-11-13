
package com.siwes.GradingSystem.controller;

import com.siwes.GradingSystem.user.Role;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String regNo;
    private String dept;
    private double cgpa;
    private String address;
    private LocalDateTime createdAt;
    private Role role;
}
