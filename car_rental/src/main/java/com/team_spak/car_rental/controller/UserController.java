package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;
import com.team_spak.car_rental.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/findAll")
    public List<ResponseUserDto> findAll() {
        return userService.findAll();
    }

    @PostMapping("/save")
    public ResponseUserDto save(@RequestBody CreateUserDto createUserDto) {
        return userService.save(createUserDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseUserDto findById(@PathVariable("id") long id){

        return userService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){

        return userService.delete(id);
    }

}
