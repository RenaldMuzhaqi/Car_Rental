package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.service.ReviewService;
import com.team_spak.car_rental.service.interfaces.ReviewServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewServiceInterface reviewServiceInterface;

    @GetMapping("/findAll/{carId}")
    public List<ResponseReviewDto> findAllByReviewIdAndCarId(@PathVariable("carId") long carId) {

        return reviewServiceInterface.findAllByReviewIdAndCarId(carId);
    }

    @PostMapping("/save/{carId}")
    public ResponseReviewDto saveByReviewIdAndCarId(@RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return reviewServiceInterface.saveByReviewIdAndCarId(createReviewDto, carId);
    }

    @GetMapping("/findById/{id}/{carId}")
    public ResponseReviewDto findByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable("carId") long carId){

        return reviewServiceInterface.findByReviewIdAndCarId(id, carId);
    }

    @PostMapping("/update/{id}/{carId}")
    public ResponseReviewDto updateByReviewIdAndCarId(@PathVariable ("id") long id, @RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return reviewServiceInterface.updateByReviewIdAndCarId(id, createReviewDto, carId);
    }

    @DeleteMapping("/delete/{id}/{carId}")
    public String deleteByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable long carId){

        return reviewServiceInterface.deleteByReviewIdAndCarId(id, carId);
    }
}
