package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskMapper taskMApper;
    private DbService service;

    @GetMapping
    List<TaskDto> getTask() {
        List<Task> tasks = service.getAllTasks();
        return taskMApper.mapToTaskDtoList(tasks);
    }

    @GetMapping("{taskId}")
    TaskDto getTaskDto(@PathVariable Long taskId) {
        Task task = service.findById(taskId);
        return taskMApper.mapToTaskDto(task);
    }

    @DeleteMapping("{taskId}")
    void deleteTask(@PathVariable Long taskId) {
    }

    @PutMapping
    TaskDto updateTask( TaskDto taskDto) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @PostMapping
    void createTask(TaskDto taskDto) {
    }
}
