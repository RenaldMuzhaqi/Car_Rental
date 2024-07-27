package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.service.interfaces.CarServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/car")
public class CarController {
    private final CarServiceInterface carServiceInterface;

    @GetMapping("/findAll/{categoryId}")
    public List<ResponseCarDto> findByCategoryId(@PathVariable("categoryId") long categoryId) {
        return carServiceInterface.findByCategoryId(categoryId);
    }

    @PostMapping("/save/{categoryId}")
    public ResponseCarDto saveNewCar(@RequestBody CreateCarDTO createCategoryDto,@PathVariable("categoryId") long categoryId) {
        return carServiceInterface.saveNewCar(createCategoryDto,categoryId);
    }

    @GetMapping("/findById/{id}")
    public ResponseCarDto findCarById(@PathVariable("id") long id){

        return carServiceInterface.findCarById(id);
    }

    @PutMapping("/{id}")
    public ResponseCarDto updateExistingCar(@RequestBody CreateCarDTO createCarDto,@PathVariable("id") long id){
        return carServiceInterface.updateExistingCar(id, createCarDto);
    }


    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){

        return carServiceInterface.deleteCarById(id);
    }
}

