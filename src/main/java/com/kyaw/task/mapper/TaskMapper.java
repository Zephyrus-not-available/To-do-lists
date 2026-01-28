package com.kyaw.task.mapper;

import com.kyaw.task.domain.CreateTaskRequest;
import com.kyaw.task.domain.UpdateTaskRequest;
import com.kyaw.task.domain.dto.CreateTaskRequestDto;
import com.kyaw.task.domain.dto.TaskDto;
import com.kyaw.task.domain.dto.UpdateTaskRequestDto;
import com.kyaw.task.domain.entity.Task;

public interface TaskMapper {

    CreateTaskRequest fromDto(CreateTaskRequestDto createTestRequestDto);

    TaskDto toDto(Task task);

    UpdateTaskRequest fromDto(UpdateTaskRequestDto updateTaskRequestDto);



}
