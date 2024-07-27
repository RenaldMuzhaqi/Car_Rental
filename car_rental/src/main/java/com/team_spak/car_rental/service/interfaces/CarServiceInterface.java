package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;

import java.util.List;

public interface CarServiceInterface {

    public List<ResponseCarDto> findAll();

    public ResponseCarDto save(CreateCarDTO createCarDTO, long categoryId);

    public ResponseCarDto findById (Long id);

    public ResponseCarDto update (Long id, CreateCarDTO createCarDTO);

    public String delete (Long id);
}
