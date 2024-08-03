package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.service.interfaces.CarServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping ("/car")
public class CarController {
    private final CarServiceInterface carServiceInterface;

    @GetMapping("/findAll/{categoryId}")
    public ResponseEntity<List<ResponseCarDto>> findByCategoryId(@PathVariable("categoryId") long categoryId) {
        return new ResponseEntity<>(carServiceInterface.findByCategoryId(categoryId), HttpStatus.OK);
    }
    @PostMapping("/save/{categoryId}")
    public ResponseEntity<ResponseCarDto>saveNewCar(@RequestBody CreateCarDTO createCarDTO,@PathVariable("categoryId") long categoryId) {
        return new ResponseEntity<>(carServiceInterface.saveNewCar(createCarDTO, categoryId), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseCarDto> findCarById(@PathVariable("id") long id){

        return ResponseEntity.ok(carServiceInterface.findCarById(id));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseCarDto> updateExistingCar(@RequestBody CreateCarDTO createCarDto,@PathVariable("id") long id){
        return ResponseEntity.ok(carServiceInterface.updateExistingCar(id, createCarDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable("id") long id){

        return ResponseEntity.ok(carServiceInterface.deleteCarById(id));
    }

    @GetMapping("/findByBrandAndModel/{brand}/{model}")
    public ResponseEntity<List<ResponseCarDto>> findByBrandAndModel(@PathVariable("brand") String brand,@PathVariable("model") String model){
        return new ResponseEntity<>(carServiceInterface.findByBrandAndModel(brand,model), HttpStatus.OK);
    }


}

