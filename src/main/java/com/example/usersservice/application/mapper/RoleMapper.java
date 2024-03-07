package com.example.usersservice.application.mapper;

import com.example.usersservice.application.dto.RoleDTO;
import com.example.usersservice.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleDTO toRoleDTO(Role role);

}
