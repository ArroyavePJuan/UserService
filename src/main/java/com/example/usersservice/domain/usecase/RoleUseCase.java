package com.example.usersservice.domain.usecase;

import com.example.usersservice.domain.api.IRoleServicePort;
import com.example.usersservice.domain.model.Role;
import com.example.usersservice.domain.spi.IRolePersistencePort;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public void saveRole(Role role){
        rolePersistencePort.saveRole(role);
    }
}
