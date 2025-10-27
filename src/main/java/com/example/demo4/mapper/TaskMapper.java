package com.example.demo4.mapper;

import com.example.demo4.entity.Task;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TaskMapper {
    Task insertTask(Task task);
    Task findTaskById(Long id);
    List<Task> findAllTasks();
    void deleteTask(Long id);
    void updateTask(Long id);
}
