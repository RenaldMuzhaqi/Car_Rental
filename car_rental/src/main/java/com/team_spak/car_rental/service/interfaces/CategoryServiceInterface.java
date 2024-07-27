package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;

import java.util.List;

public interface CategoryServiceInterface {

    public List<ResponseCategoryDto> findAll();

    public ResponseCategoryDto save(CreateCategoryDto createCategoryDto);
}
