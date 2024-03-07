package com.example.usersservice.infrastructure.out.jpa.mapper;

import com.example.usersservice.domain.model.Role;
import com.example.usersservice.infrastructure.out.jpa.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleEntityMapper {

    RoleEntity toRoleEntity(Role role);

    Role toRole(RoleEntity roleEntity);

}
