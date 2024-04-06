package com.javatechie.userservice.service;

import com.javatechie.userservice.dto.UserRequest;
import com.javatechie.userservice.dto.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    List<UserResponse> getUsers();

    UserResponse getUserById(Integer userId);
}
