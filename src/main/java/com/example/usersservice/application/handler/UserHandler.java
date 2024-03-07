package com.example.usersservice.application.handler;

import com.example.usersservice.application.dto.UserRequest;
import com.example.usersservice.application.dto.UserResponse;
import com.example.usersservice.application.dto.UserResponseIdRol;
import com.example.usersservice.application.mapper.UserRequestMapper;
import com.example.usersservice.application.mapper.UserResponseMapper;
import com.example.usersservice.domain.api.IUserServicePort;
import com.example.usersservice.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler{

    private final IUserServicePort userServicePort;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Override
    public void saveUser(UserRequest userRequest) {
        User user = userRequestMapper.toUserModel(userRequest);
        userServicePort.saveUser(user);
    }
    @Override
    public UserResponseIdRol getUserById(Long userid){
        User user = userServicePort.getUserById(userid);
        return userResponseMapper.toResponseIdRol(user);
    }
    @Override
    public List<UserResponse> getAllUsers(){
        return userResponseMapper.toResponses(userServicePort.getAllUsers());
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userResponseMapper.toResponse(userServicePort.getUserByEmail(email));
    }

    @Override
    public Long saveEmployee(UserRequest userRequest) {
        return userServicePort.saveEmployee(userRequestMapper.toUserModel(userRequest));
    }

    @Override
    public UserResponseIdRol getIdUserByEmail(String email) {
        return userResponseMapper.toResponseIdRol(userServicePort.getUserByEmail(email));
    }
}
