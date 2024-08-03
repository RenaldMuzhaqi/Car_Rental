package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;
import com.team_spak.car_rental.service.UserService;
import com.team_spak.car_rental.service.interfaces.UserServiceInterface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserServiceInterface userServiceInterface;

    @Operation(
            summary = "Find all Users REST API",
            description = "Find all Users REST API is used to find all users into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findAll")
    public List<ResponseUserDto> findAllUsers() {
        return userServiceInterface.findAllUsers();
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/save")
    public ResponseUserDto saveNewUser(@RequestBody CreateUserDto createUserDto) {
        return userServiceInterface.saveNewUser(createUserDto);
    }

    @Operation(
            summary = "Find User by Id REST API",
            description = "Find User by Id REST API is used to find a user by Id into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @GetMapping("/findById/{id}")
    public ResponseUserDto findUserById(@PathVariable("id") long id){

        return userServiceInterface.findUserById(id);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a user into database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PutMapping("/update/{id}")
    public ResponseUserDto updateExistingUser(@PathVariable ("id") long id, @RequestBody CreateUserDto createUserDto) {
      return userServiceInterface.updateExistingUser(id, createUserDto);
    }

    @Operation(
            summary = "Delete User by Id REST API",
            description = "Delete User by Id REST API is used to delete user from database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http Status 201 CREATED"
    )
    @SecurityRequirement(name = "basicAuth")
    @PreAuthorize("hasRole('MANAGER')")
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id){

        return userServiceInterface.deleteUser(id);
    }

}
