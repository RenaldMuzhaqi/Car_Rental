package com.team_spak.car_rental.controller;


import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;
import com.team_spak.car_rental.service.interfaces.CategoryServiceInterface;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceInterface categoryServiceInterface;

    @GetMapping("/findAll")
    public ResponseEntity<List<ResponseCategoryDto>> findAllCategories() {
        return new ResponseEntity<>(categoryServiceInterface.findAllCategories(), HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<ResponseCategoryDto> saveNewCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        return new ResponseEntity<>(categoryServiceInterface.saveNewCategory(createCategoryDto), HttpStatus.CREATED);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ResponseCategoryDto> findCategoryById(@PathVariable("id") long id){

        return ResponseEntity.ok(categoryServiceInterface.findCategoryById(id));
    }
    @PutMapping("update/{id}")
    public ResponseEntity<ResponseCategoryDto> updateExistingCategory(@RequestBody CreateCategoryDto createCategoryDto, @PathVariable("id") long id){
        return ResponseEntity.ok(categoryServiceInterface.updateExistingCategory(id, createCategoryDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable("id") long id){

        return ResponseEntity.ok(categoryServiceInterface.deleteCategoryById(id));
    }

}
