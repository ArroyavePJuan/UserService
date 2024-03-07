package com.example.usersservice.infrastructure.out.jpa.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rol")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rol_id")
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "role")
    @JsonManagedReference
    private List<UserEntity> userEntities;

    public RoleEntity(Long id) {
        this.id = id;
    }
}
