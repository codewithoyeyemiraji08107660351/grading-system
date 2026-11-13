
package com.siwes.GradingSystem.controller;

import com.siwes.GradingSystem.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(
            @RequestBody RegistrationRequest request) {

        service.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Registration successful");
    }


    @GetMapping("/all-users")
    public ResponseEntity<List<UserResponse>> getAllUser() {

        return ResponseEntity.ok(service.getAllUser());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(
            @PathVariable Integer id) {

        return ResponseEntity.ok(service.getUser(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<?> update(
            @PathVariable Integer id,
            @RequestBody RegistrationRequest request) {

        service.update(request, id);

        return ResponseEntity.ok("Record updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Integer id) {

        service.delete(id);

        return ResponseEntity.ok("Record deleted successfully");
    }
}
