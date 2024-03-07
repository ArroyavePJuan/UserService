package com.example.usersservice.domain.spi;

import com.example.usersservice.domain.model.Role;

public interface IRolePersistencePort {

    void saveRole(Role role);

}
