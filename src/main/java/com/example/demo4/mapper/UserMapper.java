package com.example.demo4.mapper;

import com.example.demo4.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAll();
}
