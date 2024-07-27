package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/car")
public class CarController {
    private final CarService carService;

    @GetMapping("/findAll")
    public List<ResponseCarDto> findAll() {
        return carService.findAll();
    }

    @PostMapping("/save/{categoryId}")
    public ResponseCarDto save(@RequestBody CreateCarDTO createCategoryDto,@PathVariable("categoryId") long categoryId) {
        return carService.save(createCategoryDto,categoryId);
    }

    @GetMapping("/findById/{id}")
    public ResponseCarDto findById(@PathVariable("id") long id){

        return carService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){

        return carService.delete(id);
    }
}

