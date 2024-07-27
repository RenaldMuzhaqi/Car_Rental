package com.team_spak.car_rental.controller;


import com.team_spak.car_rental.model.dto.CreateCategoryDto;
import com.team_spak.car_rental.model.dto.ResponseCategoryDto;
import com.team_spak.car_rental.service.interfaces.CategoryServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryServiceInterface categoryServiceInterface;

    @GetMapping("/findAll")
    public List<ResponseCategoryDto> findAllCategories() {
        return categoryServiceInterface.findAllCategories();
    }

    @PostMapping("/save")
    public ResponseCategoryDto saveNewCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        return categoryServiceInterface.saveNewCategory(createCategoryDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseCategoryDto findCategoryById(@PathVariable("id") long id){

        return categoryServiceInterface.findCategoryById(id);
    }
    @PutMapping("update/{id}")
    public ResponseCategoryDto updateExistingCategory(@RequestBody CreateCategoryDto createCategoryDto, @PathVariable("id") long id){
        return categoryServiceInterface.updateExistingCategory(id, createCategoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategoryById(@PathVariable("id") long id){

        return categoryServiceInterface.deleteCategoryById(id);
    }
}
