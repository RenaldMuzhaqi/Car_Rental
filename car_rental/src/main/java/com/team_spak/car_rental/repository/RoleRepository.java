package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Integer> {
}
