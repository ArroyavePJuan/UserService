package com.example.usersservice.application.mapper;

import com.example.usersservice.application.dto.UserResponse;
import com.example.usersservice.application.dto.UserResponseIdRol;
import com.example.usersservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserResponseMapper {

    UserResponse toResponse (User user);
    List<UserResponse> toResponses (List<User> users);

    @Mapping(source = "role.id", target = "rol")
    UserResponseIdRol toResponseIdRol(User user);

}
