package com.example.usersservice.domain.api;

import com.example.usersservice.domain.model.User;

import java.util.List;

public interface IUserServicePort {
    void saveUser(User user);
    User getUserById(Long userId);
    List<User> getAllUsers();
    User getUserByEmail(String email);
    Long saveEmployee(User user);


}
