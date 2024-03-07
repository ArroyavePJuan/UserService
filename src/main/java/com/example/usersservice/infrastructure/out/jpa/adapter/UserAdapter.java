package com.example.usersservice.infrastructure.out.jpa.adapter;

import com.example.usersservice.domain.model.User;
import com.example.usersservice.domain.spi.IUserPersistencePort;
import com.example.usersservice.infrastructure.exception.DocumentAlreadyRegistered;
import com.example.usersservice.infrastructure.exception.RegisteredMail;
import com.example.usersservice.infrastructure.exception.UserNotFount;
import com.example.usersservice.infrastructure.out.jpa.entity.UserEntity;
import com.example.usersservice.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.usersservice.infrastructure.out.jpa.repository.IUserEntityRepository;

import lombok.RequiredArgsConstructor;


import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class UserAdapter implements IUserPersistencePort {

    private final IUserEntityRepository userRepository;
    private final UserEntityMapper userEntityMapper;


    @Override
    public void saveUser(User user) {
        Optional<UserEntity> email = userRepository.findByEmail(user.getEmail());
        Optional<String> document = userRepository.findByDocumentNumber(user.getDocumentNumber());
        if (email.isPresent()) throw new RegisteredMail();
        else if(document.isPresent()) throw new DocumentAlreadyRegistered();
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    public User getUserById(Long userId) {
        return userEntityMapper.toUser(userRepository.findById(userId).orElseThrow(UserNotFount::new));
    }

    @Override
    public List<User> getAllUsers() {
        return userEntityMapper.toUserList(userRepository.findAll());
    }

    @Override
    public User getUserByEmail(String email) {
        return userEntityMapper.toUser(userRepository.findByEmail(email).orElseThrow(UserNotFount::new));
    }

    @Override
    public Long saveEmployee(User user) {
        Optional<UserEntity> email = userRepository.findByEmail(user.getEmail());
        Optional<String> document = userRepository.findByDocumentNumber(user.getDocumentNumber());
        if (email.isPresent()) throw new RegisteredMail();
        else if(document.isPresent()) throw new DocumentAlreadyRegistered();
        UserEntity userEntity = userEntityMapper.toUserEntity(user);
        UserEntity user1 = userRepository.save(userEntity);
        return user1.getId();
    }

}
