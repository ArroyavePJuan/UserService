package com.example.usersservice.infrastructure.configuration;

import com.example.usersservice.domain.api.IRoleServicePort;
import com.example.usersservice.domain.api.IUserServicePort;
import com.example.usersservice.domain.spi.IRolePersistencePort;
import com.example.usersservice.domain.spi.IUserPersistencePort;
import com.example.usersservice.domain.usecase.RoleUseCase;
import com.example.usersservice.domain.usecase.UserUseCase;
import com.example.usersservice.infrastructure.out.jpa.adapter.RoleAdapter;
import com.example.usersservice.infrastructure.out.jpa.adapter.UserAdapter;
import com.example.usersservice.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.example.usersservice.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.usersservice.infrastructure.out.jpa.repository.IRoleEntityRepository;
import com.example.usersservice.infrastructure.out.jpa.repository.IUserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserEntityRepository userRepository;
    private final UserEntityMapper userEntityMapper;
    private final IRoleEntityRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;
    private final PasswordEncoder passwordEncoder;


    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort(), passwordEncoder);
    }
    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase((rolePersistencePort()));
    }

}
