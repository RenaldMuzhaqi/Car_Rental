package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;

import java.util.List;

public interface CarServiceInterface {

    public List<ResponseCarDto> findByCategoryId(long categoryId);


    public ResponseCarDto saveNewCar(CreateCarDTO createCarDTO, long categoryId);

    public ResponseCarDto findCarById (Long id);

    public ResponseCarDto updateExistingCar (Long id, CreateCarDTO createCarDTO);

    public String deleteCarById (Long id);
}
