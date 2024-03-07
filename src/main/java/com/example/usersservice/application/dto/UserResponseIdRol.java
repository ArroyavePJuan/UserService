package com.example.usersservice.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseIdRol {
    private Long id;
    private String phone;
    private String email;
    private Long rol;
}
