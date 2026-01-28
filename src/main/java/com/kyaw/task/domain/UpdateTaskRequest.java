package com.kyaw.task.domain;

import com.kyaw.task.domain.entity.TaskPriority;
import com.kyaw.task.domain.entity.TaskStatus;

import java.time.LocalDate;

public record UpdateTaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskStatus status,
        TaskPriority priority
) {
}
