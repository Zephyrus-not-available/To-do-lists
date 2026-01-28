package com.kyaw.task.controller;

import com.kyaw.task.domain.CreateTaskRequest;
import com.kyaw.task.domain.UpdateTaskRequest;
import com.kyaw.task.domain.dto.CreateTaskRequestDto;
import com.kyaw.task.domain.dto.TaskDto;
import com.kyaw.task.domain.dto.UpdateTaskRequestDto;
import com.kyaw.task.domain.entity.Task;
import com.kyaw.task.mapper.TaskMapper;
import com.kyaw.task.service.TaskService;
import jakarta.validation.Valid;
import org.hibernate.query.sqm.mutation.internal.TableKeyExpressionCollector;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {
     private final TaskService taskService;
     private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(
            @Valid @RequestBody CreateTaskRequestDto createTestRequestDto
    ) {
        CreateTaskRequest createTaskRequest = taskMapper.fromDto(createTestRequestDto);
        Task task = taskService.createTask(createTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listTasks() {
        List<Task> tasks = taskService.listTasks();
        List<TaskDto> taskDtos = tasks.stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(taskDtos, HttpStatus.OK);
    }

    @PutMapping(path = "/{taskId}")
    public ResponseEntity<TaskDto> updateTask(
            @PathVariable("taskId") UUID taskId,
            @Valid @RequestBody UpdateTaskRequestDto updateTaskRequestDto
    ) {
        UpdateTaskRequest updateTaskRequest= taskMapper.fromDto(updateTaskRequestDto);
        Task task = taskService.updateTask(taskId, updateTaskRequest);
        TaskDto taskDto = taskMapper.toDto(task);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(
            @PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
