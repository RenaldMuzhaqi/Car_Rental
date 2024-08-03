package com.team_spak.car_rental.controller;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.entity.User;
import com.team_spak.car_rental.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/register")
public class RegistrationController {
    private UserService userService;

    @PostMapping("/newUser")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
        CreateUserDto user = new CreateUserDto();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        userService.registerNewUser(user);
        return "redirect:/login";
    }



}
