package com.kyaw.task.mapper.impl;

import com.kyaw.task.domain.CreateTaskRequest;
import com.kyaw.task.domain.UpdateTaskRequest;
import com.kyaw.task.domain.dto.CreateTaskRequestDto;
import com.kyaw.task.domain.dto.TaskDto;
import com.kyaw.task.domain.dto.UpdateTaskRequestDto;
import com.kyaw.task.domain.entity.Task;
import com.kyaw.task.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {
    @Override
    public CreateTaskRequest fromDto(CreateTaskRequestDto createTestRequestDto) {
        return new CreateTaskRequest(
                createTestRequestDto.title(),
                createTestRequestDto.description(),
                createTestRequestDto.dueDate(),
                createTestRequestDto.priority()
        );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getDueDate(),
                task.getStatus(),
                task.getPriority()
        );
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto updateTaskRequestDto) {
        return new UpdateTaskRequest(
                updateTaskRequestDto.title(),
                updateTaskRequestDto.description(),
                updateTaskRequestDto.dueDate(),
                updateTaskRequestDto.status(),
                updateTaskRequestDto.priority()
        );
    }
}
