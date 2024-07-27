package com.team_spak.car_rental.repository;
import com.team_spak.car_rental.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
