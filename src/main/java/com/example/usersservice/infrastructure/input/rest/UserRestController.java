package com.example.usersservice.infrastructure.input.rest;

import com.example.usersservice.application.dto.UserRequest;
import com.example.usersservice.application.dto.UserResponse;
import com.example.usersservice.application.dto.UserResponseIdRol;
import com.example.usersservice.application.handler.IUserHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserHandler userHandler;
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers(){
        return ResponseEntity.ok(userHandler.getAllUsers());
    }
    @GetMapping("{userId}")
    public ResponseEntity<UserResponseIdRol> getUserById(@PathVariable Long userId){
        return ResponseEntity.ok(userHandler.getUserById(userId));
    }
    @GetMapping("email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userHandler.getUserByEmail(email));
    }
    @PostMapping("saveEmployee")
    public ResponseEntity<Long> saveEmployee(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userHandler.saveEmployee(request));
    }
    @GetMapping("getId/email/{email}")
    public ResponseEntity<UserResponseIdRol> getIdUserByEmail(@PathVariable String email){
        return ResponseEntity.ok(userHandler.getIdUserByEmail(email));
    }
}