package com.team_spak.car_rental.service.interfaces;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;

import java.util.List;

public interface UserServiceInterface {

    public List<ResponseUserDto> findAll();

    public ResponseUserDto save(CreateUserDto createUserDto);

    public ResponseUserDto findById(long id);

    public ResponseUserDto update(long id, CreateUserDto createUserDto);

    public String delete(long id);


}
