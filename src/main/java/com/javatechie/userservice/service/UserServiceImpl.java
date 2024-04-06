package com.javatechie.userservice.service;

import com.javatechie.userservice.dto.UserRequest;
import com.javatechie.userservice.dto.UserResponse;
import com.javatechie.userservice.entity.User;
import com.javatechie.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        User user = User.builder()
                .userName(userRequest.getUserName())
                .userPassword(userRequest.getUserPassword())
                .address(userRequest.getAddress())
                .city(userRequest.getCity())
                .build();
        User savedUser = userRepository.save(user);

        UserResponse userResponse = UserResponse.builder()
                .id(savedUser.getId())
                .userName(savedUser.getUserName())
                .userPassword(savedUser.getUserPassword())
                .address(savedUser.getAddress())
                .city(savedUser.getCity())
                .build();
        return userResponse;
    }

    @Override
    public List<UserResponse> getUsers() {

        List<UserResponse> allUsers = userRepository.findAll().stream().map(user -> {
            return UserResponse.builder()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .userPassword(user.getUserPassword())
                    .address(user.getAddress())
                    .city(user.getCity())
                    .build();
        }).toList();
        return allUsers;
    }

    @Override
    public UserResponse getUserById(Integer userId) {

        User user = userRepository.findById(userId).orElse(null);
        UserResponse userResponse = null;
        if (user != null) {
            userResponse = UserResponse.builder()
                    .id(user.getId())
                    .userName(user.getUserName())
                    .userPassword(user.getUserPassword())
                    .address(user.getAddress())
                    .city(user.getCity())
                    .build();
        }
        return userResponse;
    }
}
