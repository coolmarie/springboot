package com.example.demo4.controller;

import com.example.demo4.entity.Task;
import com.example.demo4.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    TaskService taskservice;

    @PostMapping
    public void addTask(@RequestBody Task task){
        taskservice.inserTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskservice.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskservice.deleteTask(id);
    }

    @PutMapping("/{id}")
    public void updateTask(@PathVariable Long id) {
        taskservice.updateTask(id);
    }
}
