package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;

    @GetMapping("/findAll/{carId}")
    public List<ResponseReviewDto> findAllByReviewIdAndCarId(@PathVariable("carId") long carId) {

        return reviewService.findAll(carId);
    }

    @PostMapping("/save/{carId}")
    public ResponseReviewDto save(@RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return reviewService.save(createReviewDto, carId);
    }

    @GetMapping("/findById/{id}/{carId}")
    public ResponseReviewDto findByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable("carId") long carId){

        return reviewService.findByReviewIdAndCarId(id, carId);
    }

    @DeleteMapping("/delete/{id}/{carId}")
    public String deleteByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable long carId){

        return reviewService.delete(id, carId);
    }
}
