package com.kyaw.task.domain.dto;

import com.kyaw.task.domain.entity.TaskPriority;
import com.kyaw.task.domain.entity.TaskStatus;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record UpdateTaskRequestDto(
        @NotBlank(message = ERROR_MESSAGE_TITLE_LENGTH)
        @Length(min = 1, max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,
        @Nullable
        @Length(max = 1000, message = ERROR_MESSAGE_DESCRIPTION_LENGTH )
        String description,
        @Nullable
        @FutureOrPresent(message = ERROR_MESSAGE_DUE_FUTURE )
        LocalDate dueDate,
        @NotNull(message = ERROR_MESSAGE_TASK_PRIORITY)
        TaskPriority priority,
        @NotNull(message =  ERROR_MESSAGE_TASK_STATUS)
        TaskStatus status
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH =
            "Title must be between 1 and 255 characters.";

    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Description must be between 1 and 1000 characters.";

    private static final String ERROR_MESSAGE_DUE_FUTURE =
            "Due date must be in the future";

    private static final String ERROR_MESSAGE_TASK_PRIORITY =
            "Task priority must not be empty";

    private static final String ERROR_MESSAGE_TASK_STATUS =
            "Task status must not be empty";





}
