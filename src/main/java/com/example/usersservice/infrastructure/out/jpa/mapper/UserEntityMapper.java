package com.example.usersservice.infrastructure.out.jpa.mapper;

import com.example.usersservice.domain.model.User;
import com.example.usersservice.infrastructure.out.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {

    UserEntity toUserEntity(User user);

    User toUser(UserEntity userEntity);

    List<User> toUserList(List<UserEntity> userEntities);


}