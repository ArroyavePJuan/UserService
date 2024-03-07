package com.example.usersservice.infrastructure.out.jpa.repository;

import com.example.usersservice.infrastructure.out.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserEntityRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
    Optional<String> findByDocumentNumber(String document);

}
