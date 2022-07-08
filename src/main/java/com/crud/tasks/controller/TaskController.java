package com.crud.tasks.controller;


import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@AllArgsConstructor
public class TaskController {
    private TaskMapper taskMApper;
    private DbService service;

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTask() {
        List<Task> tasks = service.getAllTasks();
        return ResponseEntity.ok(taskMApper.mapToTaskDtoList(tasks));
    }

    @GetMapping("{taskId}")
    ResponseEntity<TaskDto> getTaskDto(@PathVariable Long taskId) throws TaskNotFoundException {
        return new ResponseEntity<>(taskMApper.mapToTaskDto(service.getTask(taskId)), HttpStatus.OK);
    }

    @DeleteMapping("{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        service.deleteTask(taskId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TaskDto> updateTask(@RequestBody TaskDto taskDto) {
        Task task = taskMApper.mapToTask(taskDto);
        Task savedTask = service.saveTask(task);
        return ResponseEntity.ok(taskMApper.mapToTaskDto(savedTask));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTask(@RequestBody TaskDto taskDto) {
        service.saveTask(taskMApper.mapToTask(taskDto));
        return ResponseEntity.ok().build();
    }
}
