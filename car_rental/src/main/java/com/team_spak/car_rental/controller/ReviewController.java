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

    @GetMapping("/findAll")
    public List<ResponseReviewDto> findAll() {
        return reviewService.findAll();
    }

    @PostMapping("/save")
    public ResponseReviewDto save(@RequestBody CreateReviewDto createReviewDto) {
        return reviewService.save(createReviewDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseReviewDto findById(@PathVariable("id") long id){

        return reviewService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){

        return reviewService.delete(id);
    }
}
