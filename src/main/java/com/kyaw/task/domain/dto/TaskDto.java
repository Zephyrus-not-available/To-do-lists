package com.kyaw.task.domain.dto;

import com.kyaw.task.domain.entity.TaskPriority;
import com.kyaw.task.domain.entity.TaskStatus;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus taskStatus,
        TaskPriority priority
) {
}
