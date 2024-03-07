package com.example.usersservice.application.handler;

import com.example.usersservice.application.dto.UserRequest;
import com.example.usersservice.application.dto.UserResponse;
import com.example.usersservice.application.dto.UserResponseIdRol;

import java.util.List;

public interface IUserHandler {
    void saveUser(UserRequest userRequest);
    UserResponseIdRol getUserById(Long userId);
    List<UserResponse> getAllUsers();
    UserResponse getUserByEmail(String email);
    Long saveEmployee(UserRequest userRequest);
    UserResponseIdRol getIdUserByEmail(String email);

}
