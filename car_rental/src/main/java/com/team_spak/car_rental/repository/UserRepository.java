package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {
}
