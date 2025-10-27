package com.example.demo4.controller;

import com.example.demo4.entity.Car;
import com.example.demo4.service.CarService;
import com.example.demo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "https://hggfs7-4200.csb.app")
//@RequestMapping("/cars")
public class CarController {

    @Autowired
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @CrossOrigin(origins = "https://hggfs7-4200.csb.app")
    @GetMapping("/cars")
    public List<Car> getCars() {
        return service.getAllCars();
    }
}
