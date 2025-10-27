package com.example.demo4.service;

import com.example.demo4.entity.Task;
import com.example.demo4.mapper.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskMapper taskMapper;

    public void inserTask(Task task){
        taskMapper.insertTask(task);
    }

    public void deleteTask(Long id){
        taskMapper.deleteTask(id);
    }

    public List<Task> findAll(){
        return taskMapper.findAllTasks();
    }

    public Task findById(Long id){
        return taskMapper.findTaskById(id);
    }

    public void updateTask(Long id){
        taskMapper.updateTask(id);
    }


}
