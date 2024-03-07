package com.example.usersservice.infrastructure.out.jpa.repository;

import com.example.usersservice.infrastructure.out.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleEntityRepository extends JpaRepository <RoleEntity,Long> {
}
