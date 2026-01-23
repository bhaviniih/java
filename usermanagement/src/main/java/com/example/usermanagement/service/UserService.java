package com.example.usermanagement.service;

import java.util.List;

import com.example.usermanagement.dto.UserRegisterRequest;
import com.example.usermanagement.dto.UserResponse;
import com.example.usermanagement.dto.UserUpdateRequest;

public interface UserService {

    UserResponse registerUser(UserRegisterRequest request);

    UserResponse getCurrentUser(String email);

    UserResponse updateCurrentUser(String email, UserUpdateRequest request);

    void deleteUser(Long id);

    List<UserResponse> getAllUsers();

}
