package com.example.usersservice.infrastructure.out.jpa.adapter;

import com.example.usersservice.domain.model.User;
import com.example.usersservice.infrastructure.out.jpa.entity.UserEntity;
import com.example.usersservice.infrastructure.out.jpa.mapper.UserEntityMapper;
import com.example.usersservice.infrastructure.out.jpa.repository.IUserEntityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserAdapterTest {

    @Mock
    private IUserEntityRepository userRepository;
    @Mock
    private UserEntityMapper userEntityMapper;
    @InjectMocks
    private UserAdapter userAdapter;
    private User user;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
    }

    @Test
    void saveUser() {
        userAdapter.saveUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(userEntityMapper.toUserEntity(user));
    }

    @Test
    void getUserById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        Mockito.when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        Mockito.when(userEntityMapper.toUser(userEntity)).thenReturn(new User());
        User result = userAdapter.getUserById(1L);
        Mockito.verify(userRepository).findById(1L);
        Mockito.verify(userEntityMapper).toUser(userEntity);
    }

    @Test
    void getAllUsers() {
        List<UserEntity> users = new ArrayList<>();
        users.add(userEntityMapper.toUserEntity(user));

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User>userList = userAdapter.getAllUsers();
        assertEquals(userList, userEntityMapper.toUserList(users));
    }

    @Test
    void getUserByEmail() {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail("test@test");

        Mockito.when(userRepository.findByEmail("test@test")).thenReturn(Optional.of(userEntity));
        user = userAdapter.getUserByEmail("test@test");
        assertEquals(user, userEntityMapper.toUser(userEntity));

    }

    @Test
    void saveEmployee() {
        userAdapter.saveUser(user);
        Mockito.verify(userRepository, Mockito.times(1)).save(userEntityMapper.toUserEntity(user));
    }
}