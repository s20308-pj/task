package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;
    @Test
    void mapToTaskTest() {

        //Given
        TaskDto taskDto = new TaskDto(1L, "test title", "test content");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(task.getId(), taskDto.getId());
        assertEquals(task.getTitle(), taskDto.getTitle());
        assertEquals(task.getContent(), taskDto.getContent());
    }

    @Test
    void mapToTaskDtoTest() {

        //Given
        Task task = new Task(1L, "test title", "test content");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(taskDto.getId(), task.getId());
        assertEquals(taskDto.getTitle(), task.getTitle());
        assertEquals(taskDto.getContent(), task.getContent());
    }

    @Test
    void mapToTaskDtoListTest() {
        //Given
        Task task1 = new Task(1L, "test title 1", "test content 1");
        Task task2 = new Task(2L, "test title 2", "test content 2");
        Task task3 = new Task(3L, "test title 3", "test content 3");
        List<Task> tasks = List.of(task1, task2, task3);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(tasks.size(), taskDtos.size());
    }
}