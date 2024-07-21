package com.team_spak.car_rental.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.security.Permission;
import java.security.Permissions;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long role_id;

    private String role_name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<User> permissions = new HashSet<>();

}
