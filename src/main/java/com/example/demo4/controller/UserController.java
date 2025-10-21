package com.example.demo4.controller;

import com.example.demo4.entity.User;
import com.example.demo4.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
