package com.team_spak.car_rental.service;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;
import com.team_spak.car_rental.mappers.ReviewMapper;
import com.team_spak.car_rental.model.entity.Review;
import com.team_spak.car_rental.repository.ReviewRepository;
import com.team_spak.car_rental.service.interfaces.ReviewServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class ReviewService implements ReviewServiceInterface {

    private ReviewRepository reviewRepository;
    private ReviewMapper reviewMapper;

    @Override
    public List<ResponseReviewDto> findAll(){
        List<Review> reviewList = reviewRepository.findAll();
        List<ResponseReviewDto> responseReviewDtoList = new ArrayList<>();
        for (Review review : reviewList) {
            responseReviewDtoList.add(reviewMapper.mapToResponse(review));
        }
        return responseReviewDtoList;
    }

    @Override
    public ResponseReviewDto save(CreateReviewDto createReviewDto){
        Review newReview = reviewMapper.mapToEntity(createReviewDto);
        Review savedReview = reviewRepository.save(newReview);
        return reviewMapper.mapToResponse(savedReview);
    }

    @Override
    public ResponseReviewDto findById(long id){
        Review existingReview = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));
        return reviewMapper.mapToResponse(existingReview);
    }

    @Override
    public ResponseReviewDto update(long id, CreateReviewDto createReviewDto){
        Review existingReview = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));

        existingReview.setUserName(createReviewDto.getUserName());
        existingReview.setComment(createReviewDto.getComment());
        existingReview.setRating(createReviewDto.getRating());
        Review savedReview = reviewRepository.save(existingReview);
        return reviewMapper.mapToResponse(savedReview);
    }

    @Override
    public String delete(long id){
        Review existingReview = reviewRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Review not found"));

        reviewRepository.delete(existingReview);

        return "Review with id" + id + "was succefully deleted";
    }

}
