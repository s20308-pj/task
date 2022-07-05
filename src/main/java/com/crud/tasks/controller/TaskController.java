package com.crud.tasks.controller;


import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
//    private TaskMApper taskMApper;
//    private DbService dbService;

    @GetMapping("/")
    List<TaskDto> getTask() {
        return new ArrayList<>();
    }

    @GetMapping("/{taskId}")
    TaskDto getTaskDto(@PathVariable Long taskId) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @DeleteMapping("/delete/{taskId}")
    void deleteTask(@PathVariable Long taskId) {
    }

    @PutMapping("/")
    TaskDto updateTask(@RequestBody TaskDto taskDto) {
        return new TaskDto(1L, "test title", "test_content");
    }

    @PostMapping("/")
    void createTask(@RequestBody TaskDto taskDto) {
    }
}
