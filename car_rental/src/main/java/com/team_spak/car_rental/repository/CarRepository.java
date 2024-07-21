package com.team_spak.car_rental.repository;

import com.team_spak.car_rental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository  extends JpaRepository<Car, Integer> {
}
