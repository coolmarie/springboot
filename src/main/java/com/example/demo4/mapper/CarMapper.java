package com.example.demo4.mapper;

import com.example.demo4.entity.Car;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarMapper {
    List<Car> findAllCar();
}
