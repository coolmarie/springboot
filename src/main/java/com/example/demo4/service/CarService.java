package com.example.demo4.service;

import com.example.demo4.entity.Car;
import com.example.demo4.mapper.CarMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarMapper carMapper;

    public CarService(CarMapper carMapper) {
        this.carMapper = carMapper;
    }

    public List<Car> getAllCars() {
        return carMapper.findAllCar();
    }
}
