package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;
import com.team_spak.car_rental.service.UserService;
import com.team_spak.car_rental.service.interfaces.UserServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceInterface userServiceInterface;

    @GetMapping("/findAll")
    public List<ResponseUserDto> findAllUsers() {
        return userServiceInterface.findAllUsers();
    }

    @PostMapping("/save")
    public ResponseUserDto saveNewUser(@RequestBody CreateUserDto createUserDto) {
        return userServiceInterface.saveNewUser(createUserDto);
    }

    @GetMapping("/findById/{id}")
    public ResponseUserDto findUserById(@PathVariable("id") long id){

        return userServiceInterface.findUserById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseUserDto updateExistingUser(@PathVariable ("id") long id, @RequestBody CreateUserDto createUserDto) {
      return userServiceInterface.updateExistingUser(id, createUserDto);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){

        return userServiceInterface.deleteUser(id);
    }

}
