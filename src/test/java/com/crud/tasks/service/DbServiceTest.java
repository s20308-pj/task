package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTest {

    @Autowired
    private DbService dbService;


    @Test
    void saveTaskAndGetTaskTest() {
        //Given
        Task task = new Task();
        //When
        Task taskFromDB = dbService.saveTask(task);
        //Then
        assertEquals(task.getId(), taskFromDB.getId());
        //Clean
        dbService.deleteTask(task.getId());
    }
    @Test
    void deleteTaskTest() {
        //Given
        Task task = new Task();
        dbService.saveTask(task);
        //When
        dbService.deleteTask(task.getId());
        //Then
        assertThrows(TaskNotFoundException.class, () -> dbService.getTask(task.getId()));
    }
}