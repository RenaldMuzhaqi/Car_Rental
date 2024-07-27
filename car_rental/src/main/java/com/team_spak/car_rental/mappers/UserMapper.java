package com.team_spak.car_rental.mappers;

import com.team_spak.car_rental.model.dto.CreateUserDto;
import com.team_spak.car_rental.model.dto.ResponseUserDto;
import com.team_spak.car_rental.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User mapToEntity (CreateUserDto createUserDto) {
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setPassword(createUserDto.getPassword());
        return user;
    }

    public ResponseUserDto mapToResponse (User user) {
        ResponseUserDto responseUserDto = new ResponseUserDto();
        responseUserDto.setUsername(user.getUsername());
        responseUserDto.setPassword(user.getPassword());
        responseUserDto.setId(user.getId());
        return responseUserDto;
    }
}
