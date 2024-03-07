package com.example.usersservice.infrastructure.input.rest;

import com.example.usersservice.application.dto.UserRequest;
import com.example.usersservice.infrastructure.out.jpa.auth.AuthenticationRequest;
import com.example.usersservice.infrastructure.out.jpa.auth.AuthenticationResponse;
import com.example.usersservice.infrastructure.out.jpa.auth.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("saveOwner")
    public ResponseEntity<Void> saveOwner(@RequestBody UserRequest request) {
        authenticationService.saveOwner(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("saveAdmin")
    public ResponseEntity<Void> saveAdmin(@RequestBody UserRequest request) {
        authenticationService.saveAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("saveCustomer")
    public ResponseEntity<Void> saveCustomer(@RequestBody UserRequest request) {
        authenticationService.saveCustomer(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("authenticate")
    public ResponseEntity<AuthenticationResponse> authentication(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

}
