package com.example.usermanagement.service;

import com.example.usermanagement.dto.UserRegisterRequest;
import com.example.usermanagement.dto.UserResponse;

public interface UserService {

    UserResponse registerUser(UserRegisterRequest request);
}
