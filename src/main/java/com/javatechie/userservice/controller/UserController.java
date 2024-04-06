package com.javatechie.userservice.controller;

import com.javatechie.userservice.dto.UserRequest;
import com.javatechie.userservice.dto.UserResponse;
import com.javatechie.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {

        return ResponseEntity.ok(userService.saveUser(userRequest));

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponse>> findAllUsers() {

        return ResponseEntity.ok(userService.getUsers());

    }

    @GetMapping("/fetchById/{userId}")
    public ResponseEntity<UserResponse> fetchUserById(@PathVariable Integer userId) {

        return ResponseEntity.ok(userService.getUserById(userId));

    }


}
