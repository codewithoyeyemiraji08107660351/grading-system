package com.siwes.GradingSystem.user;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tb")
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String regNo;
    private String dept;
    private double cgpa;
    private String address;
    private LocalDateTime createdAt;

    private Role role;
}
