package com.example.usermanagement.controller;

import com.example.usermanagement.dto.*;
import com.example.usermanagement.service.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // USER + ADMIN
    @GetMapping("/me")
    public UserResponse getMe(Authentication authentication) {
        return userService.getCurrentUser(authentication.getName());
    }

    // USER + ADMIN
    @PutMapping("/me")
    public UserResponse updateMe(
            Authentication authentication,
            @RequestBody UserUpdateRequest request) {

        return userService.updateCurrentUser(
                authentication.getName(), request);
    }

    // ADMIN only
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    // ADMIN only
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
