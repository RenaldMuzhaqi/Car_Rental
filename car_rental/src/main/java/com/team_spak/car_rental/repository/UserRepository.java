package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository <User, Long> {
}
