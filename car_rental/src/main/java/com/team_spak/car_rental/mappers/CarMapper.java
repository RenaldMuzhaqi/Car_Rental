package com.team_spak.car_rental.mappers;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.model.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public Car mapToEntity(CreateCarDTO createCarDTO) {
        Car car = new Car();
        car.setBrand(createCarDTO.getBrand());
        car.setModel(createCarDTO.getModel());
        car.setYear(createCarDTO.getYear());
        car.setColor(createCarDTO.getColor());
        return car;
    }
    public ResponseCarDto mapToResponse(Car car) {
        ResponseCarDto responseCarDTO = new ResponseCarDto();
        responseCarDTO.setBrand(car.getBrand());
        responseCarDTO.setModel(car.getModel());
        responseCarDTO.setYear(car.getYear());
        responseCarDTO.setColor(car.getColor());
        return responseCarDTO;
    }
}