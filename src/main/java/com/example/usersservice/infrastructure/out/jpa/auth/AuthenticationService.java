package com.example.usersservice.infrastructure.out.jpa.auth;

import com.example.usersservice.application.dto.UserRequest;
import com.example.usersservice.domain.api.IUserServicePort;
import com.example.usersservice.domain.model.User;
import com.example.usersservice.infrastructure.exception.UserNotFount;
import com.example.usersservice.infrastructure.out.jpa.entity.RoleEntity;
import com.example.usersservice.infrastructure.out.jpa.entity.UserEntity;
import com.example.usersservice.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.usersservice.infrastructure.out.jpa.repository.IUserEntityRepository;
import com.example.usersservice.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final IUserEntityRepository userEntityRepository;
    private final PasswordEncoder passwordEncoder;
    private final IUserServicePort userServicePort;
    private final UserEntityMapper userEntityMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public void saveOwner(UserRequest request) {

        var user = UserEntity.builder()
                .name(request.getName())
                .userLastName(request.getUserLastName())
                .documentNumber(request.getDocumentNumber())
                .phone(request.getPhone())
                .birthdate(request.getBirthdate())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new RoleEntity(1L))
                .build();
        userServicePort.saveUser(userEntityMapper.toUser(user));
        jwtService.generateToken(user);
    }
    public void saveCustomer(UserRequest request) {

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .userLastName(request.getUserLastName())
                .documentNumber(request.getDocumentNumber())
                .phone(request.getPhone())
                .birthdate(request.getBirthdate())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new RoleEntity(3L))
                .build();
        userServicePort.saveUser(userEntityMapper.toUser(user));
        jwtService.generateToken(user);
    }
    public void saveAdmin(UserRequest request) {

        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .userLastName(request.getUserLastName())
                .documentNumber(request.getDocumentNumber())
                .phone(request.getPhone())
                .birthdate(request.getBirthdate())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(new RoleEntity(4L))
                .build();
        userServicePort.saveUser(userEntityMapper.toUser(user));
        jwtService.generateToken(user);
    }
    public User getUserByEmail(String email) {
        return userEntityMapper.toUser(userEntityRepository.findByEmail(email).orElseThrow(UserNotFount::new));
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userEntityRepository.findByEmail(request.getEmail())
                .orElseThrow(UserNotFount::new);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
