package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.service.ReviewService;
import com.team_spak.car_rental.service.interfaces.ReviewServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewServiceInterface reviewServiceInterface;

    @GetMapping("/findAll/{carId}")
    public ResponseEntity<List<ResponseReviewDto>> findAllByReviewIdAndCarId(@PathVariable("carId") long carId) {

        return new ResponseEntity<>(reviewServiceInterface.findAllByReviewIdAndCarId(carId), HttpStatus.OK);
    }
    @PostMapping("/save/{carId}")
    public ResponseEntity<ResponseReviewDto> saveByReviewIdAndCarId(@RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return new ResponseEntity<>(reviewServiceInterface.saveByReviewIdAndCarId(createReviewDto, carId), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}/{carId}")
    public ResponseEntity<ResponseReviewDto> findByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable("carId") long carId){

        return ResponseEntity.ok(reviewServiceInterface.findByReviewIdAndCarId(id, carId));
    }
    @PostMapping("/update/{id}/{carId}")
    public ResponseEntity<ResponseReviewDto> updateByReviewIdAndCarId(@PathVariable ("id") long id, @RequestBody CreateReviewDto createReviewDto, @PathVariable("carId") long carId) {
        return ResponseEntity.ok(reviewServiceInterface.updateByReviewIdAndCarId(id, createReviewDto, carId));
    }

    @DeleteMapping("/delete/{id}/{carId}")
    public ResponseEntity<String> deleteByReviewIdAndCarId(@PathVariable("id") long id, @PathVariable long carId){

        return ResponseEntity.ok(reviewServiceInterface.deleteByReviewIdAndCarId(id, carId));
    }
}
