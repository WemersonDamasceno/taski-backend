package com.taski.taski_api.features.task.service;

import com.taski.taski_api.generated.model.TaskResponse;

import java.util.List;
import java.util.UUID;

public interface TaskService {
    List<TaskResponse> getTasks(UUID userId);
}
