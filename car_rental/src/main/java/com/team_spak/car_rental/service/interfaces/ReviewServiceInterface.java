package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateReviewDto;
import com.team_spak.car_rental.model.dto.ResponseReviewDto;

import java.util.List;

public interface ReviewServiceInterface {

    public List<ResponseReviewDto> findAll();

    public ResponseReviewDto save(CreateReviewDto createReviewDto);

    public ResponseReviewDto findById(long id);

    public ResponseReviewDto update(long id, CreateReviewDto createReviewDto);

    public String delete(long id);

}
