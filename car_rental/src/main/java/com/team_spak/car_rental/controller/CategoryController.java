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
    public List<ResponseCategoryDto> findAll() {
        return categoryServiceInterface.findAll();
    }

    @PostMapping("/save")
    public ResponseCategoryDto save(@RequestBody CreateCategoryDto createCategoryDto) {
        return categoryServiceInterface.save(createCategoryDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseCategoryDto findById(@PathVariable("id") long id){

        return categoryServiceInterface.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){

        return categoryServiceInterface.delete(id);
    }
}
