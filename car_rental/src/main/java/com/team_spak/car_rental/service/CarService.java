package com.team_spak.car_rental.service;

import com.team_spak.car_rental.model.dto.CreateCarDTO;
import com.team_spak.car_rental.model.dto.ResponseCarDto;
import com.team_spak.car_rental.mappers.CarMapper;
import com.team_spak.car_rental.model.entity.Car;
import com.team_spak.car_rental.model.entity.Category;
import com.team_spak.car_rental.repository.CarRepository;
import com.team_spak.car_rental.repository.CategoryRepository;
import com.team_spak.car_rental.service.interfaces.CarServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarService implements CarServiceInterface {
    private CarRepository carRepository;
    private CarMapper carMapper;
    private CategoryRepository categoryRepository;

    @Override
    public List<ResponseCarDto> findAll() {
        List<Car> carList = carRepository.findAll();
        List<ResponseCarDto> ResponsecarDTOList = new ArrayList<>();
        for (Car car : carList) {
            ResponsecarDTOList.add(carMapper.mapToResponse(car));
        }
        return ResponsecarDTOList;
    }


    @Override
    public ResponseCarDto save(CreateCarDTO createCarDTO,long categoryId) {
        Category existingCategory = categoryRepository.findById(categoryId).orElseThrow(()-> new RuntimeException("Category not found"));
        Car newCar = carMapper.mapToEntity(createCarDTO);
        newCar.setCategory(existingCategory);
        Car savedCar = carRepository.save(newCar);
        return carMapper.mapToResponse(savedCar);
    }

    @Override
    public ResponseCarDto findById (Long id) {
        Car existingCar = carRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Car not found"));
        return carMapper.mapToResponse(existingCar);
    }

    @Override
    public ResponseCarDto update (Long id, CreateCarDTO createCarDTO) {
        Car existingCar = carRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Car not found"));

        existingCar.setBrand(createCarDTO.getBrand());
        existingCar.setModel(createCarDTO.getModel());
        existingCar.setYear(createCarDTO.getYear());
        existingCar.setColor(createCarDTO.getColor());

        Car savedCar = carRepository.save(existingCar);
        return carMapper.mapToResponse(savedCar);
    }

    @Override
    public String delete (Long id) {
        Car existingCar = carRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Category not found"));

        carRepository.delete(existingCar);

        return "Car with id " + id + " was succesfully deleted";
    }

}