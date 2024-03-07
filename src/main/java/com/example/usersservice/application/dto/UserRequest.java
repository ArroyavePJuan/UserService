package com.example.usersservice.application.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserRequest {

    private String name;
    private String userLastName;
    private String documentNumber;
    private String phone;
    private LocalDate birthdate;
    private String email;
    private String password;

}
