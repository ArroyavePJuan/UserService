package com.example.usersservice.infrastructure.out.jpa.adapter;

import com.example.usersservice.domain.model.Role;
import com.example.usersservice.domain.spi.IRolePersistencePort;
import com.example.usersservice.infrastructure.out.jpa.mapper.RoleEntityMapper;
import com.example.usersservice.infrastructure.out.jpa.repository.IRoleEntityRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoleAdapter implements IRolePersistencePort {

    private final IRoleEntityRepository roleRepository;
    private final RoleEntityMapper roleEntityMapper;

    @Override
    public void saveRole(Role role) {
        roleEntityMapper.toRole(roleRepository.save(roleEntityMapper.toRoleEntity(role)));
    }
}